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
        mainController.init(primaryStage);
    }
    public static void main(String[] args) {
        launch();
    }
    
}
