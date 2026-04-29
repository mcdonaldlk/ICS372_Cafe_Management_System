package com.group6.model.inventory;

import com.group6.util.Ingredient;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class InventoryManager {
    private static final InventoryManager INSTANCE = new InventoryManager(true);
    private static final String DEFAULT_RESOURCE_PATH = "/com/group6/data/inventory.json";

    private Map<Ingredient, Integer> inventory;
    private Map<Ingredient, Integer> lowStockThreshold;

    public InventoryManager() {
        this(false);
    }

    private InventoryManager(boolean singleton) {
        this.inventory = new LinkedHashMap<>();
        this.lowStockThreshold = new HashMap<>();
        if (!loadFromJSON(DEFAULT_RESOURCE_PATH)) {
            seedDefaultInventory();
        }
    }

    public static InventoryManager getInstance() {
        return INSTANCE;
    }

    public boolean loadFromJSON(String filePath) {
        try (BufferedReader reader = openReader(filePath)) {
            if (reader == null) {
                return false;
            }

            JsonElement root = JsonParser.parseReader(reader);
            if (!root.isJsonArray()) {
                return false;
            }

            JsonArray items = root.getAsJsonArray();
            Map<Ingredient, Integer> loadedInventory = new LinkedHashMap<>();
            Map<Ingredient, Integer> loadedThresholds = new HashMap<>();

            for (JsonElement element : items) {
                if (!element.isJsonObject()) {
                    continue;
                }

                JsonObject item = element.getAsJsonObject();
                String id = getString(item, "id");
                String name = getString(item, "name");
                String unit = getString(item, "unit");
                int quantity = getInt(item, "quantity", 0);
                int threshold = getInt(item, "lowStockThreshold", 0);

                if (id == null || name == null || unit == null) {
                    continue;
                }

                Ingredient ingredient = new Ingredient(id, name, unit);
                loadedInventory.put(ingredient, quantity);
                loadedThresholds.put(ingredient, threshold);
            }

            if (loadedInventory.isEmpty()) {
                return false;
            }

            this.inventory = loadedInventory;
            this.lowStockThreshold = loadedThresholds;
            return true;
        } catch (IOException | RuntimeException ex) {
            return false;
        }
    }

    public boolean checkAvailability(Map<Ingredient, Double> requiredIngredients) {
        if (requiredIngredients == null || requiredIngredients.isEmpty()) {
            return true;
        }

        for (Map.Entry<Ingredient, Double> entry : requiredIngredients.entrySet()) {
            Ingredient ingredient = entry.getKey();
            int requiredAmount = toUnits(entry.getValue());
            int onHand = inventory.getOrDefault(ingredient, 0);
            if (onHand < requiredAmount) {
                return false;
            }
        }
        return true;
    }

    public boolean deductIngredients(Map<Ingredient, Double> ingredients) {
        if (!checkAvailability(ingredients)) {
            return false;
        }

        if (ingredients == null || ingredients.isEmpty()) {
            return true;
        }

        for (Map.Entry<Ingredient, Double> entry : ingredients.entrySet()) {
            Ingredient ingredient = entry.getKey();
            int requiredAmount = toUnits(entry.getValue());
            int updatedAmount = inventory.getOrDefault(ingredient, 0) - requiredAmount;
            inventory.put(ingredient, Math.max(updatedAmount, 0));
        }
        return true;
    }

    public void restock(Ingredient ingredient, int quantity) {
        if (ingredient == null || quantity <= 0) {
            return;
        }
        inventory.put(ingredient, inventory.getOrDefault(ingredient, 0) + quantity);
    }

    public List<Ingredient> getLowStockItems() {
        List<Ingredient> lowStockItems = new ArrayList<>();
        for (Map.Entry<Ingredient, Integer> entry : inventory.entrySet()) {
            int threshold = lowStockThreshold.getOrDefault(entry.getKey(), 0);
            if (entry.getValue() <= threshold) {
                lowStockItems.add(entry.getKey());
            }
        }
        return lowStockItems;
    }

    public Map<Ingredient, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<Ingredient, Integer> inventory) {
        this.inventory = inventory;
    }

    public Map<Ingredient, Integer> getLowStockThreshold() {
        return lowStockThreshold;
    }

    public void setLowStockThreshold(Map<Ingredient, Integer> lowStockThreshold) {
        this.lowStockThreshold = lowStockThreshold;
    }

    private void seedDefaultInventory() {
        Ingredient coffeeBeans = new Ingredient("ing-coffee-beans", "Coffee Beans", "grams");
        Ingredient milk = new Ingredient("ing-milk", "Milk", "milliliters");
        Ingredient sugar = new Ingredient("ing-sugar", "Sugar", "grams");
        Ingredient flour = new Ingredient("ing-flour", "Flour", "grams");
        Ingredient butter = new Ingredient("ing-butter", "Butter", "grams");
        Ingredient chocolateChips = new Ingredient("ing-choc-chips", "Chocolate Chips", "grams");

        inventory.put(coffeeBeans, 1000);
        inventory.put(milk, 5000);
        inventory.put(sugar, 2000);
        inventory.put(flour, 4000);
        inventory.put(butter, 1500);
        inventory.put(chocolateChips, 1200);

        lowStockThreshold.put(coffeeBeans, 200);
        lowStockThreshold.put(milk, 500);
        lowStockThreshold.put(sugar, 200);
        lowStockThreshold.put(flour, 300);
        lowStockThreshold.put(butter, 150);
        lowStockThreshold.put(chocolateChips, 150);
    }

    private int toUnits(Double value) {
        if (value == null || value <= 0) {
            return 0;
        }
        return (int) Math.ceil(value);
    }

    private BufferedReader openReader(String filePath) throws IOException {
        if (filePath != null && !filePath.isBlank()) {
            Path path = Paths.get(filePath);
            if (Files.exists(path)) {
                return Files.newBufferedReader(path, StandardCharsets.UTF_8);
            }

            String normalizedPath = filePath.startsWith("/") ? filePath : "/" + filePath;
            InputStream resourceStream = InventoryManager.class.getResourceAsStream(normalizedPath);
            if (resourceStream != null) {
                return new BufferedReader(new InputStreamReader(resourceStream, StandardCharsets.UTF_8));
            }
        }

        InputStream defaultStream = InventoryManager.class.getResourceAsStream(DEFAULT_RESOURCE_PATH);
        if (defaultStream != null) {
            return new BufferedReader(new InputStreamReader(defaultStream, StandardCharsets.UTF_8));
        }

        return null;
    }

    private String getString(JsonObject object, String memberName) {
        JsonElement element = object.get(memberName);
        return element == null || element.isJsonNull() ? null : element.getAsString();
    }

    private int getInt(JsonObject object, String memberName, int defaultValue) {
        JsonElement element = object.get(memberName);
        return element == null || element.isJsonNull() ? defaultValue : element.getAsInt();
    }
}
