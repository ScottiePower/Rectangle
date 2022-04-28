package com.khera;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RectangleTest {

    @Test
    public void isAdjacenctOnLeft_rectangleIsAdjacenctToAnotherRectangle_true() {
        Rectangle rectangle1 = new Rectangle(new Point(0, 1), new Point(1, 4));
        Rectangle rectangle2 = new Rectangle(new Point(1, 2), new Point(2, 3));
        assertTrue(rectangle1.isAdjacentOnLeft(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(0, 1), new Point(1, 4));
        rectangle2 = new Rectangle(new Point(1, 1), new Point(2, 4));
        assertTrue(rectangle1.isAdjacentOnLeft(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(0, 1), new Point(1, 3));
        rectangle2 = new Rectangle(new Point(1, 2), new Point(2, 4));
        assertTrue(rectangle1.isAdjacentOnLeft(rectangle2).isResult());
    }

    @Test
    public void isAdjacenctOnRight_rectangleIsAdjacenctToAnotherRectangle_true() {
        Rectangle rectangle1 = new Rectangle(new Point(0, 1), new Point(1, 4));
        Rectangle rectangle2 = new Rectangle(new Point(-1, 2), new Point(0, 3));
        assertTrue(rectangle1.isAdjacentOnRight(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(0, 1), new Point(1, 4));
        rectangle2 = new Rectangle(new Point(-1, 1), new Point(0, 4));
        assertTrue(rectangle1.isAdjacentOnRight(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(0, 1), new Point(1, 3));
        rectangle2 = new Rectangle(new Point(-1, 2), new Point(0, 4));
        assertTrue(rectangle1.isAdjacentOnRight(rectangle2).isResult());
    }

    @Test
    public void isAdjacenctOnTop_rectangleIsAdjacenctToAnotherRectangle_true() {
        Rectangle rectangle1 = new Rectangle(new Point(3, 1), new Point(4, 2));
        Rectangle rectangle2 = new Rectangle(new Point(3, 2), new Point(4, 3));
        assertTrue(rectangle1.isAdjacentOnTop(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(2, 1), new Point(5, 2));
        rectangle2 = new Rectangle(new Point(3, 2), new Point(4, 3));
        assertTrue(rectangle1.isAdjacentOnTop(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(2, 1), new Point(4, 2));
        rectangle2 = new Rectangle(new Point(3, 2), new Point(5, 3));
        assertTrue(rectangle1.isAdjacentOnTop(rectangle2).isResult());
    }

    @Test
    public void isAdjacenctOnBottom_rectangleIsAdjacenctToAnotherRectangle_true() {
        Rectangle rectangle1 = new Rectangle(new Point(3, 3), new Point(4, 4));
        Rectangle rectangle2 = new Rectangle(new Point(3, 2), new Point(4, 3));
        assertTrue(rectangle1.isAdjacentOnBottom(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(2, 3), new Point(5, 4));
        rectangle2 = new Rectangle(new Point(3, 2), new Point(4, 3));
        assertTrue(rectangle1.isAdjacentOnBottom(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(2, 3), new Point(4, 4));
        rectangle2 = new Rectangle(new Point(3, 2), new Point(5, 3));
        assertTrue(rectangle1.isAdjacentOnBottom(rectangle2).isResult());
    }

    @Test
    public void isAdjacenctOnLeft_rectangleIsAdjacenctToAnotherRectangle_false() {
        Rectangle rectangle1 = new Rectangle(new Point(0, 1), new Point(1, 4));
        Rectangle rectangle2 = new Rectangle(new Point(2, 2), new Point(3, 3));
        assertFalse(rectangle1.isAdjacentOnLeft(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(0, 1), new Point(1, 4));
        rectangle2 = new Rectangle(new Point(2, 1), new Point(3, 4));
        assertFalse(rectangle1.isAdjacentOnLeft(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(0, 1), new Point(1, 3));
        rectangle2 = new Rectangle(new Point(2, 2), new Point(3, 4));
        assertFalse(rectangle1.isAdjacentOnLeft(rectangle2).isResult());
    }

    @Test
    public void isAdjacenctOnRight_rectangleIsAdjacenctToAnotherRectangle_false() {
        Rectangle rectangle1 = new Rectangle(new Point(0, 1), new Point(1, 4));
        Rectangle rectangle2 = new Rectangle(new Point(2, 2), new Point(3, 3));
        assertFalse(rectangle1.isAdjacentOnRight(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(0, 1), new Point(1, 4));
        rectangle2 = new Rectangle(new Point(2, 1), new Point(3, 4));
        assertFalse(rectangle1.isAdjacentOnRight(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(0, 1), new Point(1, 3));
        rectangle2 = new Rectangle(new Point(2, 2), new Point(3, 4));
        assertFalse(rectangle1.isAdjacentOnRight(rectangle2).isResult());
    }

    @Test
    public void isAdjacenctOnTop_rectangleIsAdjacenctToAnotherRectangle_false() {
        Rectangle rectangle1 = new Rectangle(new Point(3, 1), new Point(4, 2));
        Rectangle rectangle2 = new Rectangle(new Point(3, 2), new Point(4, 3));
        assertTrue(rectangle1.isAdjacentOnTop(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(2, 1), new Point(5, 2));
        rectangle2 = new Rectangle(new Point(3, 2), new Point(4, 3));
        assertTrue(rectangle1.isAdjacentOnTop(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(2, 1), new Point(4, 2));
        rectangle2 = new Rectangle(new Point(3, 2), new Point(5, 3));
        assertTrue(rectangle1.isAdjacentOnTop(rectangle2).isResult());
    }

    @Test
    public void isAdjacenctOnBottom_rectangleIsAdjacenctToAnotherRectangle_false() {
        Rectangle rectangle1 = new Rectangle(new Point(3, 3), new Point(4, 4));
        Rectangle rectangle2 = new Rectangle(new Point(3, 2), new Point(4, 3));
        assertTrue(rectangle1.isAdjacentOnBottom(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(2, 3), new Point(5, 4));
        rectangle2 = new Rectangle(new Point(3, 2), new Point(4, 3));
        assertTrue(rectangle1.isAdjacentOnBottom(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(2, 3), new Point(4, 4));
        rectangle2 = new Rectangle(new Point(3, 2), new Point(5, 3));
        assertTrue(rectangle1.isAdjacentOnBottom(rectangle2).isResult());
    }

    @Test
    public void contains_rectangleContainsAnotherRectangle_true() {
        Rectangle rectangle1 = new Rectangle(new Point(1, 1), new Point(6, 4));
        Rectangle rectangle2 = new Rectangle(new Point(2, 1), new Point(4, 3));
        assertTrue(rectangle1.contains(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(-1, -2), new Point(1, 2));
        rectangle2 = new Rectangle(new Point(-1, -2), new Point(0, -1));
        assertTrue(rectangle1.contains(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(-2, -3), new Point(1, 2));
        rectangle2 = new Rectangle(new Point(-1, -2), new Point(0, -1));
        assertTrue(rectangle1.contains(rectangle2).isResult());
    }

    @Test
    public void contains_rectangleContainsAnotherRectangle_false() {
        Rectangle rectangle1 = new Rectangle(new Point(1, 2), new Point(6, 4));
        Rectangle rectangle2 = new Rectangle(new Point(2, 1), new Point(4, 3));
        assertFalse(rectangle1.contains(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(-1, -2), new Point(1, 2));
        rectangle2 = new Rectangle(new Point(-1, -2), new Point(3, -1));
        assertFalse(rectangle1.contains(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(-1, -2), new Point(0, -1));
        rectangle2 = new Rectangle(new Point(-2, -3), new Point(1, 2));
        assertFalse(rectangle1.contains(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(1, 1), new Point(2, 2));
        rectangle2 = new Rectangle(new Point(-2, -3), new Point(-1, -2));
        assertFalse(rectangle1.contains(rectangle2).isResult());
    }

    @Test
    public void intersects_rectangleIntersectsAnotherRectangle_true() {
        Rectangle rectangle1 = new Rectangle(new Point(2, 1), new Point(4, 3));
        Rectangle rectangle2 = new Rectangle(new Point(1, 1), new Point(3, 2));
        assertTrue(rectangle1.intersects(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(-5, -2), new Point(2, 3));
        rectangle2 = new Rectangle(new Point(-2, -1), new Point(5, 2));
        assertTrue(rectangle1.intersects(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(2, 1), new Point(4, 3));
        rectangle2 = new Rectangle(new Point(3, 2), new Point(5, 4));
        assertTrue(rectangle1.intersects(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(2, 1), new Point(4, 3));
        rectangle2 = new Rectangle(new Point(1, 1), new Point(6, 4));
        assertTrue(rectangle1.intersects(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(-5, 1), new Point(2, 4));
        rectangle2 = new Rectangle(new Point(-2, -2), new Point(5, 5));
        assertTrue(rectangle1.intersects(rectangle2).isResult());
    }

    @Test
    public void intersects_rectangleDoesNotIntersectAnotherRectangle_false() {
        Rectangle rectangle1 = new Rectangle(new Point(-5, 1), new Point(-3, 4));
        Rectangle rectangle2 = new Rectangle(new Point(-2, -2), new Point(5, 5));
        assertFalse(rectangle1.intersects(rectangle2).isResult());

        Rectangle rectangle3 = new Rectangle(new Point(-5, 1), new Point(3, 4));
        Rectangle rectangle4 = new Rectangle(new Point(-2, -2), new Point(5, -1));
        assertFalse(rectangle3.intersects(rectangle4).isResult());

        rectangle1 = new Rectangle(new Point(-2, 1), new Point(0, 3));
        rectangle2 = new Rectangle(new Point(3, 1), new Point(5, 4));
        assertFalse(rectangle1.intersects(rectangle2).isResult());

        rectangle1 = new Rectangle(new Point(1, 1), new Point(4, 4));
        rectangle2 = new Rectangle(new Point(0, 0), new Point(1, 2));
        ShapeTestResult result = rectangle1.intersects(rectangle2);
        assertFalse(result.isResult());
    }

    @Test
    public void run_verticalMovement_true() {
        Processor processor = new Processor();
        Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(4, 4)); // This
        Rectangle other = new Rectangle(new Point(2, -2), new Point(3, 0)); // Other
        for (int i = 0; i < 8; i++) {
            List<ShapeTestResult> results = processor.run(rectangle, other);
            List<ShapeTestResult> testsThatPassed = results.stream().filter(result -> result.isResult()).collect(Collectors.toList());
//            results.forEach(result -> System.out.printf(" %s%n", result));
//            System.out.println("---");

            // Verify test results
            if (i == 0) {
                assertTrue(testsThatPassed.isEmpty());
            }
            if (i == 1) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("is adjacent (SubLine) on bottom"));
            }
            if (i == 2) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("intersects"));
            }
            if (i == 3) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("contains"));
            }
            if (i == 4) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("contains"));
            }
            if (i == 5) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("intersects"));
            }
            if (i == 6) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("is adjacent (SubLine) on top"));
            }
            if (i == 8) {
                assertTrue(testsThatPassed.isEmpty());
            }

            // increment Y coordinate
            other = new Rectangle(new Point(2, other.getBottomLeft().getY() + 1), new Point(3, other.getTopRight().getY() + 1));
        }
    }

    @Test
    public void run_horizontalMovement_true() {
        Processor processor = new Processor();
        Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(4, 4)); // This
        Rectangle other = new Rectangle(new Point(-2, 2), new Point(0, 3)); // Other
        for (int i = 0; i < 8; i++) {
            List<ShapeTestResult> results = processor.run(rectangle, other);
            List<ShapeTestResult> testsThatPassed = results.stream().filter(result -> result.isResult()).collect(Collectors.toList());
//            results.forEach(result -> System.out.printf(" %s%n", result));
//            System.out.println("---");

            // Verify test results
            if (i == 0) {
                assertTrue(testsThatPassed.isEmpty());
            }
            if (i == 1) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("is adjacent (SubLine) on right"));
            }
            if (i == 2) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("intersects"));
            }
            if (i == 3) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("contains"));
            }
            if (i == 4) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("contains"));
            }
            if (i == 5) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("intersects"));
            }
            if (i == 6) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("is adjacent (SubLine) on left"));
            }
            if (i == 8) {
                assertTrue(testsThatPassed.isEmpty());
            }

            // increment X coordinate
            other = new Rectangle(new Point(other.getBottomLeft().getX() + 1, 2), new Point(other.getTopRight().getX() + 1, 3));
        }
    }

    @Test
    public void run_diagonalMovementLeftToRight_true() {
        Processor processor = new Processor();
        Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(4, 4)); // This
        Rectangle other = new Rectangle(new Point(-1, -2), new Point(0, 0)); // Other
        for (int i = 0; i < 8; i++) {
            List<ShapeTestResult> results = processor.run(rectangle, other);
            List<ShapeTestResult> testsThatPassed = results.stream().filter(result -> result.isResult()).collect(Collectors.toList());
//            results.forEach(result -> System.out.printf(" %s%n", result));
//            System.out.println("---");

            // Verify test results
            if (i == 0) {
                assertTrue(testsThatPassed.isEmpty());
            }
            if (i == 1) {
                assertTrue(testsThatPassed.isEmpty());
            }
            if (i == 2) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("intersects"));
            }
            if (i == 3) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("contains"));
            }
            if (i == 4) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("contains"));
            }
            if (i == 5) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("is adjacent (Partial) on left"));
            }
            if (i == 6) {
                assertTrue(testsThatPassed.isEmpty());
            }
            if (i == 8) {
                assertTrue(testsThatPassed.isEmpty());
            }

            // increment X and Y coordinates
            other = new Rectangle(new Point(other.getBottomLeft().getX() + 1, other.getBottomLeft().getY() + 1),
                    new Point(other.getTopRight().getX() + 1, other.getTopRight().getY() + 1));
        }
    }

    @Test
    public void run_diagonalMovementRightToLeft_true() {
        Processor processor = new Processor();
        Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(4, 4)); // This
        Rectangle other = new Rectangle(new Point(5, -2), new Point(6, 0)); // Other
        for (int i = 0; i < 8; i++) {
            List<ShapeTestResult> results = processor.run(rectangle, other);
            List<ShapeTestResult> testsThatPassed = results.stream().filter(result -> result.isResult()).collect(Collectors.toList());
//            results.forEach(result -> System.out.printf(" %s%n", result));
//            System.out.println("---");

            // Verify test results
            if (i == 0) {
                assertTrue(testsThatPassed.isEmpty());
            }
            if (i == 1) {
                assertTrue(testsThatPassed.isEmpty());
            }
            if (i == 2) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("intersects"));
            }
            if (i == 3) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("contains"));
            }
            if (i == 4) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("contains"));
            }
            if (i == 5) {
                assertTrue(testsThatPassed.size() == 1);
                assertTrue(testsThatPassed.get(0).getDescription().contains("is adjacent (Partial) on right"));
            }
            if (i == 6) {
                assertTrue(testsThatPassed.isEmpty());
            }
            if (i == 8) {
                assertTrue(testsThatPassed.isEmpty());
            }

            // increment X and Y coordinates
            other = new Rectangle(new Point(other.getBottomLeft().getX() - 1, other.getBottomLeft().getY() + 1),
                    new Point(other.getTopRight().getX() - 1, other.getTopRight().getY() + 1));
        }
    }

}