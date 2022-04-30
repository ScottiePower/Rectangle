package com.khera;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Processor {

    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        new Processor().process();
    }

    private void process() {
        Map<String, List<Rectangle>> rectangles = buildTestData();
        rectangles.forEach((k, v) -> {
                    System.out.printf("test for %s :%n", k);
                    List<ShapeTestResult> results = run(v.get(0), v.get(1));
                    printTestResults(results);
                }
        );
    }

    private Map<String, List<Rectangle>> buildTestData() {
        Map<String, List<Rectangle>> rectangles = new HashMap<>();
        // Build some dummy data
        rectangles.put("Intersection", List.of(new Rectangle(new Point(1, 1), new Point(4, 3)),
                new Rectangle(new Point(2, 0), new Point(3, 2))));
        rectangles.put("Containment", List.of(new Rectangle(new Point(1, 1), new Point(6, 4)),
                new Rectangle(new Point(2, 1), new Point(4, 3))));
        rectangles.put("Adjacency", List.of(new Rectangle(new Point(0, 1), new Point(1, 4)),
                new Rectangle(new Point(-1, 2), new Point(0, 3))));

        return rectangles;
    }

    public List<ShapeTestResult> run(Rectangle rectangle1, Rectangle rectangle2) {
        List<ShapeTestResult> results = new ArrayList<>();
        if (isValid(rectangle1) && isValid(rectangle2)) {

            // Intersection
            results.add(rectangle1.intersects(rectangle2));

            // Contains test
            results.add(rectangle1.contains(rectangle2));

            // Adjacently  tests
            results.add(rectangle1.isAdjacentOnRight(rectangle2));
            results.add(rectangle1.isAdjacentOnLeft(rectangle2));
            results.add(rectangle1.isAdjacentOnTop(rectangle2));
            results.add(rectangle1.isAdjacentOnBottom(rectangle2));

        }
        return results;
    }

    private boolean isValid(Rectangle rectangle1) {
        // check height - top right Y should not be less than bottom right Y
        if (rectangle1.getTopRight().getY() < rectangle1.getBottomLeft().getY()) {
            return false;
        }
        // check width - top right W should not be less than bottom right W
        if (rectangle1.getTopRight().getX() < rectangle1.getBottomLeft().getX()) {
            return false;
        }
        return true;
    }

    private void printTestResults(List<ShapeTestResult> results) {
        results.forEach(result -> {
            if (result.isResult()) {
                System.out.printf(ANSI_GREEN + " %s%n", result);
            } else {
                System.out.printf(ANSI_WHITE + " %s%n", result);
            }
        });
        System.out.println("---");
    }

}
