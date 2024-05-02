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
        double a = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2) + Math.pow(p2.getZ() - p1.getZ(), 2));
        double b = Math.sqrt(Math.pow(p3.getX() - p2.getX(), 2) + Math.pow(p3.getY() - p2.getY(), 2) + Math.pow(p3.getZ() - p2.getZ(), 2));
        double c = Math.sqrt(Math.pow(p1.getX() - p3.getX(), 2) + Math.pow(p1.getY() - p3.getY(), 2) + Math.pow(p1.getZ() - p3.getZ(), 2));
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
