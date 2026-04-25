package com.group6.view;

import javafx.scene.Parent;

public interface View {
    Parent getView();
    void initialize();
    void show();
    void refresh();
    void hide();
    void displayErrorMessage(String message);
    void clearMessages();
}
