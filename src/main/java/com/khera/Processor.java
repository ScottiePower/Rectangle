package com.khera;

import java.util.*;

public class Processor {

    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        new Processor().process(args);
    }

    private void process(String[] args) {
        System.out.println("Note: If you wish to pass custom rectangles, Please use format '(X,Y:X,Y)' for each rectangle.");
        System.out.println("The first X,Y coordinates represent the bottom left corner and the second X,Y coordinates represent the top right corner.");
        System.out.println("Example: java -jar rectangle-1.0-SNAPSHOT.jar \"(1,1:6,4)\" \"(2,1:4,3)\" ");

        Map<String, List<Rectangle>> rectangles = new HashMap<>();

        if (args.length == 2) {
            Rectangle r1 = buildRectangle(args[0]);
            Rectangle r2 = buildRectangle(args[1]);
            if (Objects.nonNull(r1) && Objects.nonNull(r2)) {
                rectangles.put("User Input " + args[0] + " " + args[1], List.of(r1, r2));
            }
        } else {
            rectangles = buildTestData();
        }

        rectangles.forEach((k, v) -> {
                    System.out.printf("test for %s :%n", k);
                    List<ShapeTestResult> results = run(v.get(0), v.get(1));
                    printTestResults(results);
                }
        );

    }

    private Rectangle buildRectangle(String input) {
        try {
            input = input.replaceAll(" ", "");
            input = input.substring(1, input.length() - 1);
            String[] tokens = input.split(":");
            if (tokens.length == 2) {
                Point bottomLeft = buildPoint(tokens[0]);
                Point topRight = buildPoint(tokens[1]);
                if (Objects.nonNull(bottomLeft) && Objects.nonNull(topRight)) {
                    return new Rectangle(bottomLeft, topRight);
                }
            }
        } catch (Exception ex) {
            System.out.println("Invalid string representation of Rectangle.");
            System.out.println("Please use format '(X,Y:X,Y)'");
            System.out.println("The first X,Y coordinates represent the bottom left corner and the second X,Y coordinates represent the top right corner");

        }
        return null;
    }

    private Point buildPoint(String input) {
        try {
            String[] tokens = input.split(",");
            if (tokens.length == 2) {
                Integer x = Integer.valueOf(tokens[0]);
                Integer y = Integer.valueOf(tokens[1]);
                return new Point(x, y);
            }

        } catch (Exception ex) {
            System.out.println("Invalid string representation of a Point.");
            System.out.println("Please use format 'X,Y'");
        }
        return null;
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

    private boolean isValid(Rectangle rectangle) {
        // check height - top right Y should not be less than bottom right Y
        if (rectangle.getTopRight().getY() <= rectangle.getBottomLeft().getY()) {
            System.out.println("Rectangle has an invalid height, height must be greater than 1. " + rectangle);
            return false;
        }
        // check width - top right W should not be less than bottom right W
        if (rectangle.getTopRight().getX() <= rectangle.getBottomLeft().getX()) {
            System.out.println("Rectangle has an invalid width, height must be greater than 1. " + rectangle);
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
