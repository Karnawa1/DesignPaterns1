package com.SDC.model;

import com.SDC.observer.ShapeObservable;
import com.SDC.observer.ShapeObserver;

import java.util.ArrayList;
import java.util.List;

public class Tetrahedron implements ShapeObservable {
    private List<ShapeObserver> observers = new ArrayList<>();
    private Point p1, p2, p3, p4;

    public Tetrahedron(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public Point getP4() {
        return p4;
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", p4=" + p4 +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tetrahedron that = (Tetrahedron) obj;
        return p1.equals(that.p1) &&
                p2.equals(that.p2) &&
                p3.equals(that.p3) &&
                p4.equals(that.p4);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(p1, p2, p3, p4);
    }

    @Override
    public void addObserver(ShapeObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ShapeObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ShapeObserver observer : observers) {
            observer.update(this);
        }
    }

}
