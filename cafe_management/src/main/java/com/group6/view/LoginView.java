package com.group6.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginView {
    private Button customerButton;
    private Button baristaButton;
    private Button managerButton;
    private TextField usernameField;
    private PasswordField passwordField;
    private Label messageLabel;

    public LoginView() {
        // TODO: Initialize UI components
    }

    public void show() {
        // TODO: Implement show
    }

    public void hide() {
        // TODO: Implement hide
    }

    public void displayErrorMessage(String message) {
        // TODO: Implement display error message
    }

    public Button getCustomerButton() {
        return customerButton;
    }

    public void setCustomerButton(Button customerButton) {
        this.customerButton = customerButton;
    }

    public Button getBaristaButton() {
        return baristaButton;
    }

    public void setBaristaButton(Button baristaButton) {
        this.baristaButton = baristaButton;
    }

    public Button getManagerButton() {
        return managerButton;
    }

    public void setManagerButton(Button managerButton) {
        this.managerButton = managerButton;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(TextField usernameField) {
        this.usernameField = usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }

    public void setMessageLabel(Label messageLabel) {
        this.messageLabel = messageLabel;
    }
}
