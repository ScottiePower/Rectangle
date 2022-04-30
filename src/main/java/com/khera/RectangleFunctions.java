package com.khera;

public interface RectangleFunctions {

    Point getBottomLeft();

    Point getTopRight();

    default ShapeTestResult contains(Rectangle other) {
        boolean containsXAxis = false;
        boolean containsYAxis = false;
        // Check that the x in BL and TR of other rectangle are in the bounds (width) of this rectangle BL and TR
        if ((other.getBottomLeft().getX() >= this.getBottomLeft().getX()) && (other.getTopRight().getX() <= this.getTopRight().getX())) {
            containsXAxis = true;
        }
        // Check that the y in BL and TR of other rectangle are in the bounds (height) of this rectangle BL and TR
        if ((other.getBottomLeft().getY() >= this.getBottomLeft().getY()) && (other.getTopRight().getY() <= this.getTopRight().getY())) {
            containsYAxis = true;
        }
        boolean containsResult = containsXAxis && containsYAxis;
        String description = containsResult == true ? this + " contains " + other : this + " does not contain " + other;
        return new ShapeTestResult(containsResult, description);
    }

    default boolean isAdjacent(Rectangle other) {
        return isAdjacentOnRight(other).isResult() || isAdjacentOnLeft(other).isResult() ||
                isAdjacentOnTop(other).isResult() || isAdjacentOnBottom(other).isResult();
    }

    default ShapeTestResult isAdjacentOnRight(Rectangle other) {
        boolean result = false;
        String typeOfMatch = "";
        boolean skip = isOutOfBounds(other) || isCorner(other);
        // check if the other rectangle is on the right
        if ((other.getBottomLeft().getX() == this.getTopRight().getX()) && !skip) {
            if ((other.getBottomLeft().getY() == this.getBottomLeft().getY()) && (other.getTopRight().getY() == this.getTopRight().getY())) {
                typeOfMatch = "Proper";
                result = true;
            } else if ((other.getBottomLeft().getY() > this.getBottomLeft().getY()) && (other.getTopRight().getY() < this.getTopRight().getY())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.getBottomLeft().getY() < this.getBottomLeft().getY()) && (other.getTopRight().getY() > this.getTopRight().getY())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.getBottomLeft().getY() > this.getBottomLeft().getY()) && (other.getBottomLeft().getY() <= this.getTopRight().getY())) {
                typeOfMatch = "Partial";
                result = true;
            } else if ((other.getTopRight().getY() > this.getBottomLeft().getY()) && (other.getTopRight().getY() <= this.getTopRight().getY())) {
                typeOfMatch = "Partial";
                result = true;
            }
        }
        String description = result == true ? this + " is adjacent (" + typeOfMatch + ") on right " + other : this + " is not adjacent on left " + other;
        return new ShapeTestResult(result, description);
    }

    default ShapeTestResult isAdjacentOnLeft(Rectangle other) {
        boolean result = false;
        String typeOfMatch = "";
        boolean skip = isOutOfBounds(other) || isCorner(other);
        // check if the other rectangle is on the left
        if ((this.getBottomLeft().getX() == other.getTopRight().getX()) && !skip) {
            if ((other.getTopRight().getY() == this.getTopRight().getY()) && (other.getBottomLeft().getY() == this.getBottomLeft().getY())) {
                typeOfMatch = "Proper";
                result = true;
            } else if ((other.getTopRight().getY() < this.getTopRight().getY()) && (other.getBottomLeft().getY() > this.getBottomLeft().getY())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.getTopRight().getY() > this.getTopRight().getY()) && (other.getBottomLeft().getY() < this.getBottomLeft().getY())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.getBottomLeft().getY() > this.getBottomLeft().getY()) && (other.getBottomLeft().getY() <= this.getTopRight().getY())) {
                typeOfMatch = "Partial";
                result = true;
            } else if ((other.getTopRight().getY() > this.getBottomLeft().getY()) && (other.getTopRight().getY() <= this.getTopRight().getY())) {
                typeOfMatch = "Partial";
                result = true;
            }
        }
        String description = result == true ? this + " is adjacent (" + typeOfMatch + ") on left " + other : this + " is not adjacent on right " + other;
        return new ShapeTestResult(result, description);
    }

    default ShapeTestResult isAdjacentOnTop(Rectangle other) {
        boolean result = false;
        String typeOfMatch = "";
        boolean skip = isOutOfBounds(other) || isCorner(other);
        // check if the other rectangle is on top
        if ((other.getBottomLeft().getY() == this.getTopRight().getY()) && !skip) {
            if ((other.getBottomLeft().getX() == this.getBottomLeft().getX()) && (other.getTopRight().getX() == this.getTopRight().getX())) {
                typeOfMatch = "Proper";
                result = true;
            } else if ((other.getBottomLeft().getX() > this.getBottomLeft().getX()) && (other.getTopRight().getX() < this.getTopRight().getX())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.getBottomLeft().getX() < this.getBottomLeft().getX()) && (other.getTopRight().getX() > this.getTopRight().getX())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.getBottomLeft().getX() > this.getBottomLeft().getX()) || (other.getTopRight().getX() > this.getTopRight().getX())) {
                typeOfMatch = "Partial";
                result = true;
            }
        }
        String description = result == true ? this + " is adjacent (" + typeOfMatch + ") on top " + other : this + " is not adjacent on top " + other;
        return new ShapeTestResult(result, description);
    }

    default ShapeTestResult isAdjacentOnBottom(Rectangle other) {
        boolean result = false;
        String typeOfMatch = "";
        boolean skip = isOutOfBounds(other) || isCorner(other);
        // check if the other rectangle is on bottom
        if ((other.getTopRight().getY() == this.getBottomLeft().getY()) && !skip) {
            if ((other.getTopRight().getX() == this.getTopRight().getX()) && (other.getBottomLeft().getX() == this.getBottomLeft().getX())) {
                typeOfMatch = "Proper";
                result = true;
            } else if ((other.getTopRight().getX() < this.getTopRight().getX()) && (other.getBottomLeft().getX() > this.getBottomLeft().getX())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.getTopRight().getX() > this.getTopRight().getX()) && (other.getBottomLeft().getX() < this.getBottomLeft().getX())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.getTopRight().getX() > this.getTopRight().getX()) || (other.getBottomLeft().getX() >= this.getBottomLeft().getX())) {
                typeOfMatch = "Partial";
                result = true;
            }
        }
        String description = result == true ? this + " is adjacent (" + typeOfMatch + ") on bottom " + other : this + " is not adjacent on bottom " + other;
        return new ShapeTestResult(result, description);
    }

    default boolean isCorner(Rectangle other) {
        return isBottomCorner(other) || isTopCorner(other);
    }

    default boolean isBottomCorner(Rectangle other) {
        boolean skip = false;
        // skip test if other rectangle is at bottom left corner of this rectangle
        if ((other.getTopRight().getY() == this.getBottomLeft().getY()) && (other.getBottomLeft().getX() == this.getTopRight().getX())) {
            skip = true;
        }
        // skip test if other rectangle is at bottom right corner of this rectangle
        if ((other.getTopRight().getY() == this.getBottomLeft().getY()) && (other.getBottomLeft().getX() == this.getTopRight().getX())) {
            skip = true;
        }
        return skip;
    }

    default boolean isTopCorner(Rectangle other) {
        boolean skip = false;
        // skip test if other rectangle is at top left corner of this rectangle
        if ((other.getBottomLeft().getY() == this.getTopRight().getY()) && (other.getTopRight().getX()) == this.getBottomLeft().getX()) {
            skip = true;
        }
        // skip test if other rectangle is at top right corner of this rectangle
        if ((other.getBottomLeft().getY() == this.getTopRight().getY()) && (other.getBottomLeft().getX() == this.getTopRight().getX())) {
            skip = true;
        }
        return skip;
    }

    default boolean isOutOfBounds(Rectangle other) {
        return isAboveOrBelow(other) || isLeftOrRight(other);
    }

    default boolean isAboveOrBelow(Rectangle other) {
        // skip test if other rectangle is above or below this rectangle
        boolean above = false;
        boolean below = false;
        if (other.getBottomLeft().getY() > this.getTopRight().getY()) {
            above = true;
        }
        if (other.getTopRight().getY() < this.getBottomLeft().getY()) {
            below = true;
        }
        return above || below;
    }

    default boolean isLeftOrRight(Rectangle other) {
        // skip test if other rectangle is left or right this rectangle
        boolean left = false;
        boolean right = false;
        if (other.getTopRight().getX() < this.getBottomLeft().getX()) {
            left = true;
        }
        if (other.getBottomLeft().getX() > this.getTopRight().getX()) {
            right = true;
        }
        return left || right;
    }

    default ShapeTestResult intersects(Rectangle other) {
        boolean intersectsResult = false;
        boolean skip = false;
        // skip test if other rectangle is above or below this rectangle
        if ((other.getBottomLeft().getY() > this.getTopRight().getY()) || (other.getTopRight().getY() < this.getBottomLeft().getY())) {
            skip = true;
        }
        // skip test if other rectangle is left or right this rectangle
        if ((other.getBottomLeft().getX() > this.getTopRight().getX()) || (other.getTopRight().getX() < this.getBottomLeft().getX())) {
            skip = true;
        }

        if (!contains(other).isResult() && !isAdjacent(other) && !skip) {
            // Check if X is in range and then check the Y
            // test if this tr.x is in the range of the other rectangle's width x range bl.x to tr.x
            if ((this.getTopRight().getX() > other.getBottomLeft().getX()) && (this.getTopRight().getX() < other.getTopRight().getX())) {
                if ((other.getTopRight().getY() <= this.getTopRight().getY()) && (other.getBottomLeft().getY() >= this.getBottomLeft().getY())) {
                    intersectsResult = true;
                }
                if ((other.getTopRight().getY() >= this.getTopRight().getY()) && (other.getBottomLeft().getY() >= this.getBottomLeft().getY())) {
                    intersectsResult = true;
                }
                if ((other.getTopRight().getY() >= this.getTopRight().getY()) && (other.getBottomLeft().getY() <= this.getBottomLeft().getY())) {
                    intersectsResult = true;
                }
            }
            if ((other.getTopRight().getX() > this.getBottomLeft().getX()) && (other.getTopRight().getX() < this.getTopRight().getX())) {
                if ((other.getTopRight().getY() <= this.getTopRight().getY()) && (other.getBottomLeft().getY() >= this.getBottomLeft().getY())) {
                    intersectsResult = true;
                }
                if ((other.getTopRight().getY() >= this.getTopRight().getY()) && (other.getBottomLeft().getY() >= this.getBottomLeft().getY())) {
                    intersectsResult = true;
                }
                if ((other.getTopRight().getY() <= this.getTopRight().getY()) && (other.getBottomLeft().getY() <= this.getBottomLeft().getY())) {
                    intersectsResult = true;
                }
            }

            // Diagonal use case - right to left
            if ((this.getTopRight().getX() > other.getBottomLeft().getX()) && (other.getTopRight().getX() >= this.getTopRight().getX())) {
                intersectsResult = true;
            }
        }

        String description = intersectsResult == true ? this + " intersects " + other : this + " does not intersect " + other;
        return new ShapeTestResult(intersectsResult, description);
    }

}
