package com.group6.view;

import com.group6.controller.AuthController;
import com.group6.controller.MainController;
import com.group6.model.user.Barista;
import com.group6.model.user.Customer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginView implements View {
    private MainController mainController;
    private AuthController authController;
    
    // Customer pane components
    private TextField customerNameField;
    private Button customerButton;
    private Label customerMessageLabel;
    
    // Barista pane components
    private TextField baristaUsernameField;
    private PasswordField baristaPasswordField;
    private Button baristaButton;
    private Label baristaMessageLabel;
    
    // Manager pane components
    private TextField managerUsernameField;
    private PasswordField managerPasswordField;
    private Button managerButton;
    private Label managerMessageLabel;
    
    private VBox customerPane;
    private VBox baristaPane;
    private VBox managerPane;
    private BorderPane rootContainer;
    private boolean isInitialized = false;

    // Strict black and white colors
    private static final String BLACK = "#000000";
    private static final String WHITE = "#FFFFFF";
    private static final String LIGHT_GRAY = "#F0F0F0";
    private static final String BORDER_COLOR = "#000000";

    public LoginView(MainController mainController, AuthController authController) {
        this.mainController = mainController;
        this.authController = authController;
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
        rootContainer.setPrefSize(1200, 800);
        
        // Top section with title
        VBox topSection = createTopSection();
        rootContainer.setTop(topSection);
        
        // Center section with three panes
        HBox centerSection = createThreePaneSection();
        rootContainer.setCenter(centerSection);
        
        // Bottom section
        VBox bottomSection = createBottomSection();
        rootContainer.setBottom(bottomSection);
        
        // Set margins on the center section
        BorderPane.setMargin(centerSection, new Insets(0, 50, 0, 50));
    }

    private VBox createTopSection() {
        VBox topSection = new VBox(20);
        topSection.setAlignment(Pos.CENTER);
        topSection.setPadding(new Insets(40, 0, 30, 0));
        topSection.setStyle("-fx-background-color: " + WHITE + ";");
        
        Label titleLabel = new Label("Brew & Bite");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 48));
        titleLabel.setTextFill(Color.web(BLACK));
        
        Label subtitleLabel = new Label("Cafe Management System");
        subtitleLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        subtitleLabel.setTextFill(Color.web("#444444"));
        
        // Decorative line
        Separator separator = new Separator();
        separator.setMaxWidth(200);
        separator.setStyle("-fx-background-color: " + BLACK + ";");
        
        Label instructionLabel = new Label("Select your role and login below");
        instructionLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        instructionLabel.setTextFill(Color.web("#666666"));
        
        topSection.getChildren().addAll(
            titleLabel, subtitleLabel, separator, instructionLabel
        );
        
        return topSection;
    }

    private HBox createThreePaneSection() {
        HBox panesContainer = new HBox(20);
        panesContainer.setAlignment(Pos.CENTER);
        panesContainer.setPadding(new Insets(20, 0, 20, 0));
        
        customerPane = createCustomerPane();
        baristaPane = createBaristaPane();
        managerPane = createManagerPane();
        
        panesContainer.getChildren().addAll(customerPane, baristaPane, managerPane);
        
        HBox.setHgrow(customerPane, Priority.ALWAYS);
        HBox.setHgrow(baristaPane, Priority.ALWAYS);
        HBox.setHgrow(managerPane, Priority.ALWAYS);
        
        return panesContainer;
    }

    private VBox createCustomerPane() {
        VBox pane = new VBox(20);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(30, 25, 30, 25));
        pane.setStyle(
            "-fx-background-color: " + WHITE + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 5;"
        );
        pane.setMaxWidth(350);
        pane.setMinWidth(300);
        
        // Title
        Label titleLabel = new Label("Customer");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.web(BLACK));
        
        // Description
        Label descLabel = new Label("Browse menu & place orders");
        descLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 13));
        descLabel.setTextFill(Color.web("#555555"));
        descLabel.setWrapText(true);
        descLabel.setAlignment(Pos.CENTER);
        
        // Separator
        Separator separator = new Separator();
        separator.setStyle("-fx-background-color: " + BLACK + ";");
        
        // Name field
        Label nameLabel = new Label("Your Name");
        nameLabel.setTextFill(Color.web(BLACK));
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        customerNameField = new TextField();
        customerNameField.setPromptText("Enter your name");
        customerNameField.setPrefHeight(40);
        customerNameField.setStyle(
            "-fx-background-color: " + WHITE + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 3;" +
            "-fx-padding: 5 10;"
        );
        customerNameField.setOnAction(e -> handleCustomerLogin());
        
        // Message label
        customerMessageLabel = new Label();
        customerMessageLabel.setTextFill(Color.web(BLACK));
        customerMessageLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        customerMessageLabel.setWrapText(true);
        customerMessageLabel.setAlignment(Pos.CENTER);
        customerMessageLabel.setVisible(false);
        
        // Login button
        customerButton = createStyledButton("Start Ordering");
        customerButton.setOnAction(e -> handleCustomerLogin());
        
        pane.getChildren().addAll(
            titleLabel, descLabel, separator,
            nameLabel, customerNameField, customerMessageLabel,
            customerButton
        );
        
        return pane;
    }

    private VBox createBaristaPane() {
        VBox pane = new VBox(20);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(30, 25, 30, 25));
        pane.setStyle(
            "-fx-background-color: " + WHITE + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 5;"
        );
        pane.setMaxWidth(350);
        pane.setMinWidth(300);
        
        // Title
        Label titleLabel = new Label("Barista");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.web(BLACK));
        
        // Description
        Label descLabel = new Label("Manage orders & fulfillments");
        descLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 13));
        descLabel.setTextFill(Color.web("#555555"));
        descLabel.setWrapText(true);
        descLabel.setAlignment(Pos.CENTER);
        
        // Separator
        Separator separator = new Separator();
        separator.setStyle("-fx-background-color: " + BLACK + ";");
        
        // Username field
        Label usernameLabel = new Label("Username");
        usernameLabel.setTextFill(Color.web(BLACK));
        usernameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        baristaUsernameField = new TextField();
        baristaUsernameField.setPromptText("Enter username");
        baristaUsernameField.setPrefHeight(40);
        baristaUsernameField.setStyle(
            "-fx-background-color: " + WHITE + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 3;" +
            "-fx-padding: 5 10;"
        );
        
        // Password field
        Label passwordLabel = new Label("Password");
        passwordLabel.setTextFill(Color.web(BLACK));
        passwordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        baristaPasswordField = new PasswordField();
        baristaPasswordField.setPromptText("Enter password");
        baristaPasswordField.setPrefHeight(40);
        baristaPasswordField.setStyle(
            "-fx-background-color: " + WHITE + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 3;" +
            "-fx-padding: 5 10;"
        );
        baristaPasswordField.setOnAction(e -> handleBaristaLogin());
        
        // Message label
        baristaMessageLabel = new Label();
        baristaMessageLabel.setTextFill(Color.web(BLACK));
        baristaMessageLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        baristaMessageLabel.setWrapText(true);
        baristaMessageLabel.setAlignment(Pos.CENTER);
        baristaMessageLabel.setVisible(false);
        
        // Login button
        baristaButton = createStyledButton("Login as Barista");
        baristaButton.setOnAction(e -> handleBaristaLogin());
        
        pane.getChildren().addAll(
            titleLabel, descLabel, separator,
            usernameLabel, baristaUsernameField,
            passwordLabel, baristaPasswordField,
            baristaMessageLabel, baristaButton
        );
        
        return pane;
    }

    private VBox createManagerPane() {
        VBox pane = new VBox(20);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(30, 25, 30, 25));
        pane.setStyle(
            "-fx-background-color: " + WHITE + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 5;"
        );
        pane.setMaxWidth(350);
        pane.setMinWidth(300);
        
        // Title
        Label titleLabel = new Label("Manager");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.web(BLACK));
        
        // Description
        Label descLabel = new Label("Oversee operations & inventory");
        descLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 13));
        descLabel.setTextFill(Color.web("#555555"));
        descLabel.setWrapText(true);
        descLabel.setAlignment(Pos.CENTER);
        
        // Separator
        Separator separator = new Separator();
        separator.setStyle("-fx-background-color: " + BLACK + ";");
        
        // Username field
        Label usernameLabel = new Label("Username");
        usernameLabel.setTextFill(Color.web(BLACK));
        usernameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        managerUsernameField = new TextField();
        managerUsernameField.setPromptText("Enter username");
        managerUsernameField.setPrefHeight(40);
        managerUsernameField.setStyle(
            "-fx-background-color: " + WHITE + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 3;" +
            "-fx-padding: 5 10;"
        );
        
        // Password field
        Label passwordLabel = new Label("Password");
        passwordLabel.setTextFill(Color.web(BLACK));
        passwordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        managerPasswordField = new PasswordField();
        managerPasswordField.setPromptText("Enter password");
        managerPasswordField.setPrefHeight(40);
        managerPasswordField.setStyle(
            "-fx-background-color: " + WHITE + ";" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 3;" +
            "-fx-padding: 5 10;"
        );
        managerPasswordField.setOnAction(e -> handleManagerLogin());
        
        // Message label
        managerMessageLabel = new Label();
        managerMessageLabel.setTextFill(Color.web(BLACK));
        managerMessageLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        managerMessageLabel.setWrapText(true);
        managerMessageLabel.setAlignment(Pos.CENTER);
        managerMessageLabel.setVisible(false);
        
        // Login button
        managerButton = createStyledButton("Login as Manager");
        managerButton.setOnAction(e -> handleManagerLogin());
        
        pane.getChildren().addAll(
            titleLabel, descLabel, separator,
            usernameLabel, managerUsernameField,
            passwordLabel, managerPasswordField,
            managerMessageLabel, managerButton
        );
        
        return pane;
    }

    private VBox createBottomSection() {
        VBox bottomSection = new VBox(10);
        bottomSection.setAlignment(Pos.CENTER);
        bottomSection.setPadding(new Insets(20));
        bottomSection.setStyle("-fx-background-color: " + WHITE + ";");
        
        Separator topSeparator = new Separator();
        topSeparator.setMaxWidth(800);
        topSeparator.setStyle("-fx-background-color: " + BLACK + ";");
        
        Label footerLabel = new Label("© 2024 Brew & Bite - All rights reserved");
        footerLabel.setTextFill(Color.web(BLACK));
        footerLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        
        Label hintLabel = new Label("Default credentials: barista/barista123 | manager/manager123");
        hintLabel.setTextFill(Color.web("#555555"));
        hintLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
        
        bottomSection.getChildren().addAll(topSeparator, footerLabel, hintLabel);
        
        return bottomSection;
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(200);
        button.setPrefHeight(40);
        button.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        button.setStyle(
            "-fx-background-color: " + BLACK + ";" +
            "-fx-text-fill: " + WHITE + ";" +
            "-fx-font-weight: bold;" +
            "-fx-font-size: 14;" +
            "-fx-background-radius: 3;" +
            "-fx-border-color: " + BLACK + ";" +
            "-fx-border-width: 2;" +
            "-fx-cursor: hand;"
        );
        
        // Simple hover effect (static, no animation)
        button.setOnMouseEntered(e -> 
            button.setStyle(
                "-fx-background-color: " + WHITE + ";" +
                "-fx-text-fill: " + BLACK + ";" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14;" +
                "-fx-background-radius: 3;" +
                "-fx-border-color: " + BLACK + ";" +
                "-fx-border-width: 2;" +
                "-fx-cursor: hand;"
            )
        );
        
        button.setOnMouseExited(e -> 
            button.setStyle(
                "-fx-background-color: " + BLACK + ";" +
                "-fx-text-fill: " + WHITE + ";" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14;" +
                "-fx-background-radius: 3;" +
                "-fx-border-color: " + BLACK + ";" +
                "-fx-border-width: 2;" +
                "-fx-cursor: hand;"
            )
        );
        
        return button;
    }

    private void handleCustomerLogin() {
        String name = customerNameField.getText().trim();
        
        if (name.isEmpty()) {
            showMessage(customerMessageLabel, "Please enter your name", false);
            return;
        }
        Customer customer = new Customer(name);
        customerMessageLabel.setVisible(false);
        authController.handleCustomerLogin(customer.getName());
        showMessage(customerMessageLabel, "Welcome, " + customer.getName() + "!", true);
    }

    private void handleBaristaLogin() {
        String username = baristaUsernameField.getText().trim();
        String password = baristaPasswordField.getText();
        
        if (username.isEmpty() || password.isEmpty()) {
            showMessage(baristaMessageLabel, "Please enter both username and password", false);
            return;
        }
        
        baristaMessageLabel.setVisible(false);
        boolean success = authController.handleBaristaLogin(username, password);
        
        if (success) {
            showMessage(baristaMessageLabel, "Barista login successful.", true);
        } else {
            showMessage(baristaMessageLabel, "Invalid credentials. Please try again.", false);
            baristaPasswordField.clear();
        }
    }

    private void handleManagerLogin() {
        String username = managerUsernameField.getText().trim();
        String password = managerPasswordField.getText();
        
        if (username.isEmpty() || password.isEmpty()) {
            showMessage(managerMessageLabel, "Please enter both username and password", false);
            return;
        }
        
        managerMessageLabel.setVisible(false);
        boolean success = authController.handleManagerLogin(username, password);
        
        if (success) {
            showMessage(managerMessageLabel, "Manager login successful.", true);
        } else {
            showMessage(managerMessageLabel, "Invalid credentials. Please try again.", false);
            managerPasswordField.clear();
        }
    }

    private void showMessage(Label messageLabel, String message, boolean isSuccess) {
        messageLabel.setText(message);
        messageLabel.setStyle(
            "-fx-text-fill: " + BLACK + ";" +
            "-fx-font-size: 12px;" +
            "-fx-padding: 5;" +
            "-fx-font-weight: bold;"
        );
        messageLabel.setVisible(true);
    }

    @Override
    public void refresh() {
        customerNameField.clear();
        baristaUsernameField.clear();
        baristaPasswordField.clear();
        managerUsernameField.clear();
        managerPasswordField.clear();
        clearMessages();
    }

    @Override
    public void show() {
        rootContainer.setVisible(true);
    }

    @Override
    public void hide() {
        rootContainer.setVisible(false);
    }

    @Override
    public void displayErrorMessage(String message) {
        showMessage(customerMessageLabel, message, false);
    }

    @Override
    public void clearMessages() {
        customerMessageLabel.setVisible(false);
        baristaMessageLabel.setVisible(false);
        managerMessageLabel.setVisible(false);
    }
}