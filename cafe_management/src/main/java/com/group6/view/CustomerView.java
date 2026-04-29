package com.group6.view;

import com.group6.controller.MainController;
import com.group6.controller.MenuController;
import com.group6.controller.OrderController;
import com.group6.model.menu.Beverage;
import com.group6.model.menu.MenuItem;
import com.group6.model.menu.Pastry;
import com.group6.model.user.Customer;
import com.group6.util.BeverageType;
import com.group6.util.PastryType;
import com.group6.util.Size;
import com.group6.util.CustomizationType;
import com.group6.util.Customization;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.List;

public class CustomerView implements View {
    private Customer customer;
    private OrderController orderController;
    private MenuController menuController;
    private MainController mainController;
    private MenuItem currentSelectedItem;
    
    private BorderPane rootContainer;
    private boolean isInitialized = false;
    
    // Menu catalog
    private ListView<MenuItem> menuListView;
    private TabPane menuTabPane;
    
    // Item details
    private Label selectedItemNameLabel;
    private Label selectedItemPriceLabel;
    private ComboBox<String> sizeComboBox;
    private VBox customizationBox;
    private Spinner<Integer> quantitySpinner;
    private Button addToOrderButton;
    
    // Current order
    private ListView<String> orderListView;
    private Label subtotalLabel;
    private Label taxLabel;
    private Label totalLabel;
    private Button clearOrderButton;
    private Button placeOrderButton;
    private Label orderCountLabel;
    
    // Order data
    private ObservableList<String> orderItems;
    private double subtotal = 0.0;
    private static final double TAX_RATE = 0.08;
    
    // Colors
    private static final String BLACK = "#000000";
    private static final String WHITE = "#FFFFFF";
    private static final String LIGHT_GRAY = "#F5F5F5";
    private static final String BORDER_GRAY = "#E0E0E0";

    public CustomerView(Customer customer, OrderController orderController, 
                       MenuController menuController, MainController mainController) {
        this.customer = customer;
        this.orderController = orderController;
        this.menuController = menuController;
        this.mainController = mainController;
        this.orderItems = FXCollections.observableArrayList();
    }

    @Override
    public Parent getView() {
        if (!isInitialized) {
            initialize();
            isInitialized = true;
        }
        return rootContainer;
    }

    @Override
    public void initialize() {
        rootContainer = new BorderPane();
        rootContainer.setStyle("-fx-background-color: " + WHITE + ";");
        
        // Top bar
        HBox topBar = createTopBar();
        rootContainer.setTop(topBar);
        
        // Center content with three columns
        HBox centerContent = createCenterContent();
        rootContainer.setCenter(centerContent);
    }

    private HBox createTopBar() {
        HBox topBar = new HBox();
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setPadding(new Insets(12, 20, 12, 20));
        topBar.setStyle(
            "-fx-background-color: " + WHITE + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 0 0 2 0;"
        );
        
        // Customer name on left
        Label customerLabel = new Label("Customer: " + customer.getName());
        customerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        customerLabel.setTextFill(Color.web(BLACK));
        
        // Spacer
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        // Logout button on right
        Button logoutButton = createLogoutButton();
        
        topBar.getChildren().addAll(customerLabel, spacer, logoutButton);
        return topBar;
    }

    private Button createLogoutButton() {
        Button logoutButton = new Button("Logout");
        logoutButton.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        logoutButton.setStyle(
            "-fx-background-color: " + WHITE + ";" +
            "-fx-text-fill: " + BLACK + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 3;" +
            "-fx-cursor: hand;" +
            "-fx-padding: 5 15;"
        );
        logoutButton.setOnMouseEntered(e -> 
            logoutButton.setStyle(
                "-fx-background-color: " + BLACK + ";" +
                "-fx-text-fill: " + WHITE + ";" +
                "-fx-border-color: " + BLACK + ";" +
                "-fx-border-width: 1;" +
                "-fx-border-radius: 3;" +
                "-fx-cursor: hand;" +
                "-fx-padding: 5 15;"
            )
        );
        logoutButton.setOnMouseExited(e -> 
            logoutButton.setStyle(
                "-fx-background-color: " + WHITE + ";" +
                "-fx-text-fill: " + BLACK + ";" +
                "-fx-border-color: " + BLACK + ";" +
                "-fx-border-width: 1;" +
                "-fx-border-radius: 3;" +
                "-fx-cursor: hand;" +
                "-fx-padding: 5 15;"
            )
        );
        logoutButton.setOnAction(e -> mainController.logout());
        return logoutButton;
    }

    private HBox createCenterContent() {
        HBox centerContent = new HBox(2);
        centerContent.setPadding(new Insets(2));
        centerContent.setStyle("-fx-background-color: " + BLACK + ";");
        
        // Column 1: Menu Catalog (25% width)
        VBox menuColumn = createMenuColumn();
        menuColumn.setPrefWidth(300);
        
        // Column 2: Item Details (35% width)
        VBox detailsColumn = createDetailsColumn();
        detailsColumn.setPrefWidth(400);
        
        // Column 3: Current Order (40% width)
        VBox orderColumn = createOrderColumn();
        orderColumn.setPrefWidth(500);
        
        centerContent.getChildren().addAll(menuColumn, detailsColumn, orderColumn);
        
        return centerContent;
    }

    private VBox createMenuColumn() {
        VBox column = new VBox(0);
        column.setStyle("-fx-background-color: " + WHITE + ";");
        
        // Column header
        Label headerLabel = new Label("Menu Catalog");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        headerLabel.setTextFill(Color.web(WHITE));
        headerLabel.setStyle("-fx-background-color: " + BLACK + ";");
        headerLabel.setPadding(new Insets(12, 15, 12, 15));
        headerLabel.setMaxWidth(Double.MAX_VALUE);
        
        // Tab pane for categories
        menuTabPane = new TabPane();
        menuTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        
        Tab beveragesTab = new Tab("Beverages");
        beveragesTab.setContent(createBeverageList());
        
        Tab pastriesTab = new Tab("Pastries");
        pastriesTab.setContent(createPastryList());
        
        menuTabPane.getTabs().addAll(beveragesTab, pastriesTab);
        
        column.getChildren().addAll(headerLabel, menuTabPane);
        VBox.setVgrow(menuTabPane, Priority.ALWAYS);
        
        return column;
    }

    private ListView<MenuItem> createBeverageList() {
        ListView<MenuItem> listView = new ListView<>();
        List<MenuItem> beverageList = menuController.getAvailableBeverages();
        ObservableList<MenuItem> beverages = FXCollections.observableArrayList();
        if (beverageList != null) {
            beverages.addAll(beverageList);
        }
        listView.setItems(beverages);
        listView.setCellFactory(param -> new MenuItemListCell());
        listView.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldVal, newVal) -> {
                if (newVal != null) {
                    updateItemDetails(newVal);
                }
            }
        );
        return listView;
    }

    private ListView<MenuItem> createPastryList() {
        ListView<MenuItem> listView = new ListView<>();
        List<MenuItem> pastryList = menuController.getAvailablePastries();
        ObservableList<MenuItem> pastries = FXCollections.observableArrayList();
        if (pastryList != null) {
            pastries.addAll(pastryList);
        }
        listView.setItems(pastries);
        listView.setCellFactory(param -> new MenuItemListCell());
        listView.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldVal, newVal) -> {
                if (newVal != null) {
                    updateItemDetails(newVal);
                }
            }
        );
        return listView;
    }

    private VBox createDetailsColumn() {
        VBox column = new VBox(0);
        column.setStyle("-fx-background-color: " + WHITE + ";");
        
        // Column header
        Label headerLabel = new Label("Item Details");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        headerLabel.setTextFill(Color.web(WHITE));
        headerLabel.setStyle("-fx-background-color: " + BLACK + ";");
        headerLabel.setPadding(new Insets(12, 15, 12, 15));
        headerLabel.setMaxWidth(Double.MAX_VALUE);
        
        // Scrollable content
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: " + WHITE + ";");
        
        VBox content = new VBox(15);
        content.setPadding(new Insets(20));
        content.setStyle("-fx-background-color: " + WHITE + ";");
        
        // Item name and price
        selectedItemNameLabel = new Label("Select an item");
        selectedItemNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        selectedItemNameLabel.setTextFill(Color.web(BLACK));
        selectedItemNameLabel.setWrapText(true);
        
        selectedItemPriceLabel = new Label("");
        selectedItemPriceLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        selectedItemPriceLabel.setTextFill(Color.web("#666666"));
        
        Separator sep1 = new Separator();
        sep1.setStyle("-fx-background-color: " + BLACK + ";");
        
        // Size selection
        Label sizeLabel = new Label("Size");
        sizeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        sizeLabel.setTextFill(Color.web(BLACK));
        
        sizeComboBox = new ComboBox<>();
        sizeComboBox.getItems().addAll("Small", "Medium", "Large");
        sizeComboBox.setValue("Medium");
        sizeComboBox.setPrefWidth(Double.MAX_VALUE);
        sizeComboBox.setStyle(
            "-fx-background-color: " + WHITE + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 3;"
        );
        
        Separator sep2 = new Separator();
        sep2.setStyle("-fx-background-color: " + BLACK + ";");
        
        // Customizations
        Label customLabel = new Label("Customizations");
        customLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        customLabel.setTextFill(Color.web(BLACK));
        
        customizationBox = new VBox(8);
        customizationBox.setPadding(new Insets(5, 0, 5, 10));
        
        addCustomization("Extra Shot", 0.50);
        addCustomization("Decaf", 0.25);
        addCustomization("Oat Milk", 0.75);
        addCustomization("Almond Milk", 0.75);
        addCustomization("Sugar-Free Syrup", 0.30);
        addCustomization("Whipped Cream", 0.50);
        addCustomization("Extra Foam", 0.25);
        
        Separator sep3 = new Separator();
        sep3.setStyle("-fx-background-color: " + BLACK + ";");
        
        // Quantity
        Label qtyLabel = new Label("Quantity");
        qtyLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        qtyLabel.setTextFill(Color.web(BLACK));
        
        quantitySpinner = new Spinner<>(1, 10, 1);
        quantitySpinner.setPrefWidth(120);
        quantitySpinner.setStyle(
            "-fx-background-color: " + WHITE + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 1;"
        );
        
        // Add to order button
        addToOrderButton = new Button("Add to Order");
        addToOrderButton.setPrefWidth(Double.MAX_VALUE);
        addToOrderButton.setPrefHeight(40);
        addToOrderButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        addToOrderButton.setStyle(
            "-fx-background-color: " + BLACK + ";" +
            "-fx-text-fill: " + WHITE + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 3;" +
            "-fx-cursor: hand;"
        );
        addToOrderButton.setOnMouseEntered(e -> 
            addToOrderButton.setStyle(
                "-fx-background-color: " + WHITE + ";" +
                "-fx-text-fill: " + BLACK + ";" +
                "-fx-border-color: " + BLACK + ";" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 3;" +
                "-fx-cursor: hand;"
            )
        );
        addToOrderButton.setOnMouseExited(e -> 
            addToOrderButton.setStyle(
                "-fx-background-color: " + BLACK + ";" +
                "-fx-text-fill: " + WHITE + ";" +
                "-fx-border-color: " + BLACK + ";" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 3;" +
                "-fx-cursor: hand;"
            )
        );
        addToOrderButton.setOnAction(e -> handleAddToOrder());
        
        content.getChildren().addAll(
            selectedItemNameLabel, selectedItemPriceLabel, sep1,
            sizeLabel, sizeComboBox, sep2,
            customLabel, customizationBox, sep3,
            qtyLabel, quantitySpinner,
            addToOrderButton
        );
        
        scrollPane.setContent(content);
        column.getChildren().addAll(headerLabel, scrollPane);
        VBox.setVgrow(scrollPane, Priority.ALWAYS);
        
        return column;
    }

    private VBox createOrderColumn() {
        VBox column = new VBox(0);
        column.setStyle("-fx-background-color: " + WHITE + ";");
        
        // Column header
        Label headerLabel = new Label("Current Order");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        headerLabel.setTextFill(Color.web(WHITE));
        headerLabel.setStyle("-fx-background-color: " + BLACK + ";");
        headerLabel.setPadding(new Insets(12, 15, 12, 15));
        headerLabel.setMaxWidth(Double.MAX_VALUE);
        
        // Order items list
        orderListView = new ListView<>();
        orderListView.setItems(orderItems);
        orderListView.setStyle("-fx-background-color: " + WHITE + ";");
        
        // Totals section
        VBox totalsSection = new VBox(10);
        totalsSection.setPadding(new Insets(15));
        totalsSection.setStyle(
            "-fx-background-color: " + LIGHT_GRAY + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 1 0 1 0;"
        );
        
        // Subtotal row
        HBox subtotalRow = createTotalRow("Subtotal:", "$0.00");
        subtotalLabel = (Label) subtotalRow.getChildren().get(2);
        
        // Tax row
        HBox taxRow = createTotalRow("Tax (8%):", "$0.00");
        taxLabel = (Label) taxRow.getChildren().get(2);
        
        // Total row
        HBox totalRow = new HBox(10);
        totalRow.setAlignment(Pos.CENTER_LEFT);
        Label totalTextLabel = new Label("Total:");
        totalTextLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        totalTextLabel.setTextFill(Color.web(BLACK));
        Region spacerTotal = new Region();
        HBox.setHgrow(spacerTotal, Priority.ALWAYS);
        totalLabel = new Label("$0.00");
        totalLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        totalLabel.setTextFill(Color.web(BLACK));
        totalRow.getChildren().addAll(totalTextLabel, spacerTotal, totalLabel);
        
        totalsSection.getChildren().addAll(subtotalRow, taxRow, totalRow);
        
        // Buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setPadding(new Insets(15));
        buttonBox.setAlignment(Pos.CENTER);
        
        clearOrderButton = new Button("Clear Order");
        clearOrderButton.setPrefWidth(150);
        clearOrderButton.setPrefHeight(40);
        clearOrderButton.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        clearOrderButton.setStyle(
            "-fx-background-color: " + WHITE + ";" +
            "-fx-text-fill: " + BLACK + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 3;" +
            "-fx-cursor: hand;"
        );
        clearOrderButton.setOnMouseEntered(e -> 
            clearOrderButton.setStyle(
                "-fx-background-color: " + BLACK + ";" +
                "-fx-text-fill: " + WHITE + ";" +
                "-fx-border-color: " + BLACK + ";" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 3;" +
                "-fx-cursor: hand;"
            )
        );
        clearOrderButton.setOnMouseExited(e -> 
            clearOrderButton.setStyle(
                "-fx-background-color: " + WHITE + ";" +
                "-fx-text-fill: " + BLACK + ";" +
                "-fx-border-color: " + BLACK + ";" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 3;" +
                "-fx-cursor: hand;"
            )
        );
        clearOrderButton.setOnAction(e -> handleClearOrder());
        
        placeOrderButton = new Button("Place Order");
        placeOrderButton.setPrefWidth(150);
        placeOrderButton.setPrefHeight(40);
        placeOrderButton.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        placeOrderButton.setStyle(
            "-fx-background-color: " + BLACK + ";" +
            "-fx-text-fill: " + WHITE + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 3;" +
            "-fx-cursor: hand;"
        );
        placeOrderButton.setOnMouseEntered(e -> 
            placeOrderButton.setStyle(
                "-fx-background-color: " + WHITE + ";" +
                "-fx-text-fill: " + BLACK + ";" +
                "-fx-border-color: " + BLACK + ";" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 3;" +
                "-fx-cursor: hand;"
            )
        );
        placeOrderButton.setOnMouseExited(e -> 
            placeOrderButton.setStyle(
                "-fx-background-color: " + BLACK + ";" +
                "-fx-text-fill: " + WHITE + ";" +
                "-fx-border-color: " + BLACK + ";" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 3;" +
                "-fx-cursor: hand;"
            )
        );
        placeOrderButton.setOnAction(e -> handlePlaceOrder());
        
        buttonBox.getChildren().addAll(clearOrderButton, placeOrderButton);
        
        column.getChildren().addAll(headerLabel, orderListView, totalsSection, buttonBox);
        VBox.setVgrow(orderListView, Priority.ALWAYS);
        
        return column;
    }

    private HBox createTotalRow(String labelText, String valueText) {
        HBox row = new HBox(10);
        row.setAlignment(Pos.CENTER_LEFT);
        
        Label textLabel = new Label(labelText);
        textLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        textLabel.setTextFill(Color.web(BLACK));
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        Label valueLabel = new Label(valueText);
        valueLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        valueLabel.setTextFill(Color.web(BLACK));
        
        row.getChildren().addAll(textLabel, spacer, valueLabel);
        return row;
    }

    private void addCustomization(String name, double price) {
        CheckBox checkBox = new CheckBox(name + " (+$" + String.format("%.2f", price) + ")");
        checkBox.setFont(Font.font("Arial", FontWeight.NORMAL, 13));
        checkBox.setTextFill(Color.web(BLACK));
        checkBox.setStyle("-fx-background-color: " + WHITE + ";");
        checkBox.setUserData(new CustomizationData(name, price));
        customizationBox.getChildren().add(checkBox);
    }

    private void updateItemDetails(MenuItem item) {
        this.currentSelectedItem = item;
        selectedItemNameLabel.setText(item.getName());
        selectedItemPriceLabel.setText("Base Price: $" + String.format("%.2f", item.getBasePrice()));
        
        if (item instanceof Beverage) {
            sizeComboBox.setVisible(true);
            sizeComboBox.setManaged(true);
        } else {
            sizeComboBox.setVisible(false);
            sizeComboBox.setManaged(false);
        }
    }

    private void handleAddToOrder() {
        String itemName = (currentSelectedItem != null) ? currentSelectedItem.getName() : selectedItemNameLabel.getText();
        if ("Select an item".equals(itemName) || currentSelectedItem == null) {
            return;
        }
        
        Size sizeEnum = null;
        String sizeValue = sizeComboBox.getValue();
        if (sizeComboBox.isVisible() && sizeValue != null) {
            try {
                sizeEnum = Size.valueOf(sizeValue.toUpperCase());
            } catch (Exception e) {
                sizeEnum = null;
            }
        }
        int quantity = quantitySpinner.getValue();
        
        // Collect customizations
        List<Customization> customizations = new ArrayList<>();
        List<String> customizationNames = new ArrayList<>();
        
        for (javafx.scene.Node node : customizationBox.getChildren()) {
            if (node instanceof CheckBox && ((CheckBox) node).isSelected()) {
                CustomizationData data = (CustomizationData) ((CheckBox) node).getUserData();
                customizationNames.add(data.getName());
                CustomizationType type = mapNameToType(data.getName());
                if (type != null) {
                    customizations.add(new Customization(type, data.getPrice()));
                }
            }
        }

        if (!orderController.addItemToOrder(currentSelectedItem, quantity, sizeEnum, customizations)) {
            showAlert("Out of Stock", "There are not enough ingredients available for this item.");
            return;
        }
        
        // Calculate price
        double itemTotal = 0.0;
        if (currentSelectedItem != null) {
            itemTotal = currentSelectedItem.calculatePrice(sizeEnum, customizations) * quantity;
        }
        
        // Build display string
        StringBuilder sb = new StringBuilder();
        sb.append(quantity).append("x ").append(itemName);
        if (sizeEnum != null) {
            sb.append(" (").append(sizeEnum).append(")");
        }
        if (!customizationNames.isEmpty()) {
            sb.append(" [").append(String.join(", ", customizationNames)).append("]");
        }
        sb.append(" - $").append(String.format("%.2f", itemTotal));
        
        orderItems.add(sb.toString());
        subtotal += itemTotal;
        updateTotals();
        
        // Reset selections
        quantitySpinner.getValueFactory().setValue(1);
        for (javafx.scene.Node node : customizationBox.getChildren()) {
            if (node instanceof CheckBox) {
                ((CheckBox) node).setSelected(false);
            }
        }
    }

    // Map display name to customization type (best-effort)
    private CustomizationType mapNameToType(String name) {
        if (name == null) return null;
        switch (name) {
            case "Extra Shot": return CustomizationType.EXTRA_SHOT;
            case "Decaf": return CustomizationType.EXTRA_SHOT; // approximate
            case "Oat Milk": return CustomizationType.OAT_MILK;
            case "Almond Milk": return CustomizationType.ALMOND_MILK;
            case "Sugar-Free Syrup": return CustomizationType.VANILLA;
            case "Whipped Cream": return CustomizationType.WHIPPED_CREAM;
            case "Extra Foam": return CustomizationType.EXTRA_SYRUP;
            default: return null;
        }
    }

    private void handleClearOrder() {
        orderItems.clear();
        subtotal = 0.0;
        updateTotals();
    }

    private void handlePlaceOrder() {
        if (orderItems.isEmpty()) {
            return;
        }
        
        // Place order through controller
        // orderController.placeOrder(...)
        
        showAlert("Order Placed", "Your order has been placed successfully!");
        handleClearOrder();
    }

    private void updateTotals() {
        double tax = subtotal * TAX_RATE;
        double total = subtotal + tax;
        
        subtotalLabel.setText("$" + String.format("%.2f", subtotal));
        taxLabel.setText("$" + String.format("%.2f", tax));
        totalLabel.setText("$" + String.format("%.2f", total));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Removed mock data creation methods

    // Inner classes
    private class MenuItemListCell extends ListCell<MenuItem> {
        @Override
        protected void updateItem(MenuItem item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
                setGraphic(null);
            } else {
                VBox cell = new VBox(3);
                cell.setPadding(new Insets(8));
                
                Label nameLabel = new Label(item.getName());
                nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 13));
                nameLabel.setTextFill(Color.web(BLACK));
                
                Label descLabel = new Label(item.getDescription());
                descLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
                descLabel.setTextFill(Color.web("#666666"));
                descLabel.setWrapText(true);
                
                Label priceLabel = new Label("$" + String.format("%.2f", item.getBasePrice()));
                priceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                priceLabel.setTextFill(Color.web(BLACK));
                
                cell.getChildren().addAll(nameLabel, descLabel, priceLabel);
                setGraphic(cell);
            }
        }
    }

    private class CustomizationData {
        private String name;
        private double price;
        
        CustomizationData(String name, double price) {
            this.name = name;
            this.price = price;
        }
        
        String getName() { return name; }
        double getPrice() { return price; }
    }

    @Override public void refresh() { updateTotals(); }
    @Override public void clearMessages() {}
    @Override public void show() { rootContainer.setVisible(true); }
    @Override public void hide() { rootContainer.setVisible(false); }
    @Override public void displayErrorMessage(String message) {}
}
