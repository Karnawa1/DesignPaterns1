package com.SDC.util;

import com.SDC.model.Point;
import org.tinylog.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderUtil {

    public static List<Point[]> readPointsFromFile(String filePath) {
        try {
            return Files.lines(Paths.get(filePath))
                    .map(FileReaderUtil::parseLineToPointArray)
                    .filter(points -> points != null)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            Logger.error(e, "Error reading file");
            throw new RuntimeException("Error reading file", e);
        }
    }

    public static Point[] parseLineToPointArray(String line) {
        try {
            String[] parts = line.split(";");
            if (parts.length != 12) return null; // Ensure there are 12 values
            double[] coords = new double[12];
            for (int i = 0; i < parts.length; i++) {
                coords[i] = Double.parseDouble(parts[i].trim());
            }
            return new Point[]{
                    new Point(coords[0], coords[1], coords[2]),
                    new Point(coords[3], coords[4], coords[5]),
                    new Point(coords[6], coords[7], coords[8]),
                    new Point(coords[9], coords[10], coords[11])
            };
        } catch (NumberFormatException e) {
            Logger.error(e, "Invalid number format in line: " + line);
            return null; // Handle parsing errors
        }
    }
}
