package com.SDC.service;

import com.SDC.model.Point;
import com.SDC.model.Tetrahedron;

public class ShapeService {

    public double calculateSurfaceArea(Tetrahedron tetrahedron) {
        Point p1 = tetrahedron.getP1();
        Point p2 = tetrahedron.getP2();
        Point p3 = tetrahedron.getP3();
        Point p4 = tetrahedron.getP4();

        return calculateTriangleArea(p1, p2, p3) +
                calculateTriangleArea(p1, p2, p4) +
                calculateTriangleArea(p1, p3, p4) +
                calculateTriangleArea(p2, p3, p4);
    }

    private double calculateTriangleArea(Point p1, Point p2, Point p3) {
        double a = distance(p1, p2);
        System.out.println(distance(p1, p2));
        double b = distance(p2, p3);
        double c = distance(p3, p1);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private double distance(Point p1, Point p2) {

        return (Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) +
                Math.pow(p2.getY() - p1.getY(), 2) +
                Math.pow(p2.getZ() - p1.getZ(), 2)));
    }
}
