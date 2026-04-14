package com.group6.view;

import com.group6.model.menu.MenuItem;
import com.group6.model.order.Order;
import com.group6.model.order.OrderItem;
import com.group6.util.Size;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.List;

public class CustomerOrderView {
    private ComboBox<MenuItem> itemSelector;
    private ListView<MenuItem> catalogView;
    private ListView<OrderItem> orderCartView;
    private ComboBox<Size> sizeSelector;
    private ListView<Object> customizationSelector;
    private Label totalLabel;
    private Button addButton;
    private Button placeOrderButton;
    private Button clearButton;

    public CustomerOrderView() {
        // TODO: Initialize UI components
    }

    public void refreshCatalog(List<MenuItem> menuItems) {
        // TODO: Implement refresh catalog
    }

    public void refreshCart(Order order) {
        // TODO: Implement refresh cart
    }

    public void showIngredientAlert(String message) {
        // TODO: Implement show ingredient alert
    }

    public ComboBox<MenuItem> getItemSelector() {
        return itemSelector;
    }

    public void setItemSelector(ComboBox<MenuItem> itemSelector) {
        this.itemSelector = itemSelector;
    }

    public ListView<MenuItem> getCatalogView() {
        return catalogView;
    }

    public void setCatalogView(ListView<MenuItem> catalogView) {
        this.catalogView = catalogView;
    }

    public ListView<OrderItem> getOrderCartView() {
        return orderCartView;
    }

    public void setOrderCartView(ListView<OrderItem> orderCartView) {
        this.orderCartView = orderCartView;
    }

    public ComboBox<Size> getSizeSelector() {
        return sizeSelector;
    }

    public void setSizeSelector(ComboBox<Size> sizeSelector) {
        this.sizeSelector = sizeSelector;
    }

    public ListView<Object> getCustomizationSelector() {
        return customizationSelector;
    }

    public void setCustomizationSelector(ListView<Object> customizationSelector) {
        this.customizationSelector = customizationSelector;
    }

    public Label getTotalLabel() {
        return totalLabel;
    }

    public void setTotalLabel(Label totalLabel) {
        this.totalLabel = totalLabel;
    }

    public Button getAddButton() {
        return addButton;
    }

    public void setAddButton(Button addButton) {
        this.addButton = addButton;
    }

    public Button getPlaceOrderButton() {
        return placeOrderButton;
    }

    public void setPlaceOrderButton(Button placeOrderButton) {
        this.placeOrderButton = placeOrderButton;
    }

    public Button getClearButton() {
        return clearButton;
    }

    public void setClearButton(Button clearButton) {
        this.clearButton = clearButton;
    }
}
