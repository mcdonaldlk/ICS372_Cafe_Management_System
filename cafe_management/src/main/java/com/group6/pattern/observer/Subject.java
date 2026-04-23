package com.group6.pattern.observer;

public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers(String eventType);
}