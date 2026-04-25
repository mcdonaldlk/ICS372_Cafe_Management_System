package com.group6;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;

import com.group6.controller.AuthController;
import com.group6.controller.MainController;
import com.group6.view.LoginView;

public class BrewAndBite extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create controllers
        MainController mainController = new MainController();
        AuthController authController = new AuthController(mainController);
        
        // Create login view with controllers
        LoginView loginView = new LoginView(mainController, authController);
        
        // Set up the scene
        Scene scene = new Scene(loginView.getView(), 1100, 750);
        primaryStage.setTitle("Brew & Bite - Cafe Management System");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(700);
        
        // Show the login view
        loginView.show();
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
    
}
