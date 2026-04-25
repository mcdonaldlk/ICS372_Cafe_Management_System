package com.group6.controller;

import javax.swing.text.View;

import com.group6.model.user.Barista;
import com.group6.model.user.Customer;
import com.group6.model.user.Manager;
import com.group6.model.user.User;
import com.group6.view.LoginView;
import com.group6.view.CustomerOrderView;
import com.group6.view.BaristaView;
import com.group6.view.ManagerView;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

    private Stage primaryStage;
    private Scene scene;
    private Parent rootContainer;
    
    private User currentUser;

    private AuthController authController;
    private OrderController orderController;
    private MenuController menuController;
    private InventoryController inventoryController;

    private View currentView;

    private LoginView loginView;
    private CustomerOrderView customerOrderView;
    private BaristaView baristaView;
    private ManagerView managerView;        

    public MainController() {
        this.currentUser = null;
        this.authController = new AuthController(this);
        this.orderController = new OrderController();
        this.menuController = new MenuController();
        this.inventoryController = new InventoryController();   
    }

    public void init(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
        // Create login view with controllers
        LoginView loginView = new LoginView(authController);
        
        // Set up the scene
        Scene scene = new Scene(loginView.getView(), 1100, 750);
        primaryStage.setTitle("Brew & Bite - Cafe Management System");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(700);
        
        // Show the login view
        primaryStage.show();
    }

    public void showLoginView() {
        scene.setRoot(loginView.getView());
    }

    public void switchToCustomerView(Customer customer) {
        if(customerOrderView == null) {
            customerOrderView = new CustomerOrderView();
        }
        scene.setRoot(customerOrderView.getView());
        customerOrderView.refresh();
        this.currentUser = customer;
    }

    public void switchToBaristaView(Barista barista) {
        if(baristaView == null) {
            baristaView = new BaristaView();
        }   
        scene.setRoot(baristaView.getView());
        baristaView.refresh();
        this.currentUser = barista;
    }

    public void switchToManagerView(Manager user) {
        if(managerView == null) {
            managerView = new ManagerView();
        }
        scene.setRoot(managerView.getView());
        managerView.refresh();
        this.currentUser = user;
    }

    public void logout() {
        this.currentUser = null;
        showLoginView();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }


}
