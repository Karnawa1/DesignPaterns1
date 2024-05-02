package com.SDC;

import com.SDC.model.Point;
import com.SDC.model.Tetrahedron;
import com.SDC.factory.ShapeFactory;
import com.SDC.service.ShapeService;
import com.SDC.exception.ShapeException;
import com.SDC.util.FileReaderUtil;
import org.tinylog.Logger;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/tetrahedron_points.txt";  // Adjust the path as necessary
        List<Point[]> pointGroups = FileReaderUtil.readPointsFromFile(filePath);

        ShapeService service = new ShapeService();

        for (Point[] group : pointGroups) {
            try {
                if (group.length == 4) {  // Ensure there are exactly four points
                    Tetrahedron tetrahedron = ShapeFactory.createTetrahedron(group[0], group[1], group[2], group[3]);
                    double surfaceArea = service.calculateSurfaceArea(tetrahedron);
                    System.out.println("Created Tetrahedron with surface area: " + surfaceArea);
                }
            } catch (ShapeException e) {
                Logger.error(e, "Failed to create Tetrahedron: " + e.getMessage());
            }
        }
    }
}