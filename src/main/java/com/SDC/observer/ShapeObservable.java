package com.SDC.observer;

public interface ShapeObservable {
    void addObserver(ShapeObserver observer);
    void removeObserver(ShapeObserver observer);
    void notifyObservers();
}

