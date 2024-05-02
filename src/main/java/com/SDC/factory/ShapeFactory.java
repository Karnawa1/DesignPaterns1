package com.SDC.factory;

import com.SDC.exception.ShapeException;
import com.SDC.model.Point;
import com.SDC.model.Tetrahedron;

public class ShapeFactory {
    public static Tetrahedron createTetrahedron(Point p1, Point p2, Point p3, Point p4) throws ShapeException {
        if (!isValidTetrahedron(p1, p2, p3, p4)) {
            throw new ShapeException("Invalid points for forming a tetrahedron.");
        }
        return new Tetrahedron(p1, p2, p3, p4);
    }

    private static boolean isValidTetrahedron(Point p1, Point p2, Point p3, Point p4) {

        // Check non-collinearity of any three points
        if (areCollinear(p1, p2, p3) || areCollinear(p1, p2, p4) ||
                areCollinear(p1, p3, p4) || areCollinear(p2, p3, p4)) {
            return false;
        }

        double coplanarDet = areNonCoplanar(p1, p2, p3, p4);
        // Check non-coplanarity of all points
        return coplanarDet != 0;
    }

    private static boolean areCollinear(Point p1, Point p2, Point p3) {
        // Vector from p1 to p2
        double x1 = p2.getX() - p1.getX();
        double y1 = p2.getY() - p1.getY();
        double z1 = p2.getZ() - p1.getZ();

        // Vector from p1 to p3
        double x2 = p3.getX() - p1.getX();
        double y2 = p3.getY() - p1.getY();
        double z2 = p3.getZ() - p1.getZ();

        // Cross product of vectors (x1, y1, z1) and (x2, y2, z2)
        double crossX = y1 * z2 - z1 * y2;
        double crossY = z1 * x2 - x1 * z2;
        double crossZ = x1 * y2 - y1 * x2;

        // If the cross product is (0,0,0), vectors are collinear
        return crossX == 0 && crossY == 0 && crossZ == 0;
    }

    private static double areNonCoplanar(Point p1, Point p2, Point p3, Point p4) {
        double x1 = p1.getX(), y1 = p1.getY(), z1 = p1.getZ();
        double x2 = p2.getX(), y2 = p2.getY(), z2 = p2.getZ();
        double x3 = p3.getX(), y3 = p3.getY(), z3 = p3.getZ();
        double x4 = p4.getX(), y4 = p4.getY(), z4 = p4.getZ();

        double matrixDet = x1 * (y2 * (z3 * 1 - z4 * 1) - z2 * (y3 * 1 - y4 * 1) + 1 * (y3 * z2 - y2 * z3))
                - y1 * (x2 * (z3 * 1 - z4 * 1) - z2 * (x3 * 1 - x4 * 1) + 1 * (x3 * z2 - x2 * z3))
                + z1 * (x2 * (y3 * 1 - y4 * 1) - y2 * (x3 * 1 - x4 * 1) + 1 * (x3 * y2 - x2 * y3))
                - 1   * (x2 * (y3 * z4 - y4 * z3) - y2 * (x3 * z4 - x4 * z3) + z2 * (x3 * y4 - x4 * y3));

        return matrixDet;
    }
}
