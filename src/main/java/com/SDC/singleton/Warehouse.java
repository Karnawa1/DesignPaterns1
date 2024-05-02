package com.SDC.singleton;


import com.SDC.model.Tetrahedron;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse instance;
    private Map<Tetrahedron, Double> surfaceAreas;

    private Warehouse() {
        surfaceAreas = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void updateSurfaceArea(Tetrahedron tetrahedron, double area) {
        surfaceAreas.put(tetrahedron, area);
    }

    public double getSurfaceArea(Tetrahedron tetrahedron) {
        return surfaceAreas.getOrDefault(tetrahedron, 0.0);
    }
}
