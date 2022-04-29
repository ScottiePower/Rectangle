package com.khera;

public interface RectangleFunctions {

    Point getBottomLeft();

    Point getTopRight();

    default ShapeTestResult contains(Rectangle other) {
        boolean containsXAxis = false;
        boolean containsYAxis = false;
        // Check if x and y points of other rectangle are within this rectangle
        if ((other.getBottomLeft().getX() >= this.getBottomLeft().getX()) && (other.getTopRight().getX() <= this.getTopRight().getX())) {
            containsXAxis = true;
        }
        if ((other.getBottomLeft().getY() >= this.getBottomLeft().getY()) && (other.getTopRight().getY() <= this.getTopRight().getY())) {
            containsYAxis = true;
        }
        boolean containsResult = containsXAxis && containsYAxis;
        String description = containsResult == true ? this + " contains " + other : this + " does not contain " + other;
        return new ShapeTestResult(containsResult, description);
    }
    default boolean isAdjacent(Rectangle other) {
        return isAdjacentOnLeft(other).isResult() || isAdjacentOnRight(other).isResult() ||
                isAdjacentOnTop(other).isResult() || isAdjacentOnBottom(other).isResult();
    }
    default ShapeTestResult isAdjacentOnLeft(Rectangle other) {
        boolean result = false;
        String typeOfMatch = "";
        // check if the other rectangle is on the left
        if (other.getBottomLeft().getX() == this.getTopRight().getX()) {
            if ((other.getBottomLeft().getY() == this.getBottomLeft().getY()) && (other.getTopRight().getY() == this.getTopRight().getY())) {
                typeOfMatch = "Proper";
                result = true;
            } else if ((other.getBottomLeft().getY() > this.getBottomLeft().getY()) && (other.getTopRight().getY() < this.getTopRight().getY())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.getBottomLeft().getY() < this.getBottomLeft().getY()) && (other.getTopRight().getY() > this.getTopRight().getY())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.getBottomLeft().getY() > this.getBottomLeft().getY()) || (other.getTopRight().getY() > this.getTopRight().getY())) {
                typeOfMatch = "Partial";
                result = true;
            }
        }
        String description = result == true ? this + " is adjacent (" + typeOfMatch + ") on left " + other : this + " is not adjacent on left " + other;
        return new ShapeTestResult(result, description);
    }

    default ShapeTestResult isAdjacentOnRight(Rectangle other) {
        boolean result = false;
        String typeOfMatch = "";
        // check if the other rectangle is on the right
        if (this.getBottomLeft().getX() == other.getTopRight().getX()) {
            if ((other.getTopRight().getY() == this.getTopRight().getY()) && (other.getBottomLeft().getY() == this.getBottomLeft().getY())) {
                typeOfMatch = "Proper";
                result = true;
            } else if ((other.getTopRight().getY() < this.getTopRight().getY()) && (other.getBottomLeft().getY() > this.getBottomLeft().getY())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.getTopRight().getY() > this.getTopRight().getY()) && (other.getBottomLeft().getY() < this.getBottomLeft().getY())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.getTopRight().getY() > this.getTopRight().getY()) || (other.getBottomLeft().getY() < this.getBottomLeft().getY()) && !(other.getTopRight().getY() == this.getBottomLeft().getY())) {
                typeOfMatch = "Partial";
                result = true;
            }
        }
        String description = result == true ? this + " is adjacent (" + typeOfMatch + ") on right " + other : this + " is not adjacent on right " + other;
        return new ShapeTestResult(result, description);
    }

    default ShapeTestResult isAdjacentOnTop(Rectangle other) {
        boolean result = false;
        String typeOfMatch = "";
        boolean skip = false;
        // skip test if other rectangle is pass this rectangle
        if (other.getBottomLeft().getX() > this.getTopRight().getX()) {
            skip = true;
        }

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
        boolean skip = false;
        // skip test if other rectangle is below this rectangle
        if (other.getTopRight().getY() < this.getBottomLeft().getY()) {
            skip = true;
        }
        // skip test if other rectangle is at corner of this rectangle
        if ((other.getTopRight().getY() == this.getBottomLeft().getY()) && (other.getBottomLeft().getX() == this.getTopRight().getX())) {
            skip = true;
        }

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
            } else if ((other.getTopRight().getX() > this.getTopRight().getX()) || (other.getBottomLeft().getX() > this.getBottomLeft().getX())) {
                typeOfMatch = "Partial";
                result = true;
            }
        }
        String description = result == true ? this + " is adjacent (" + typeOfMatch + ") on bottom " + other : this + " is not adjacent on bottom " + other;
        return new ShapeTestResult(result, description);
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
