package com.khera;


import lombok.Data;

@Data
public class Rectangle {

    private final Point bottomLeft;
    private final Point topRight;


    public ShapeTestResult intersects(Rectangle other) {
        boolean intersectsResult = false;
        boolean skip = false;
        // skip test if other rectangle is above or below this rectangle
        if ((other.bottomLeft.getY() > this.topRight.getY()) || (other.topRight.getY() < this.bottomLeft.getY())) {
            skip = true;
        }
        // skip test if other rectangle is left or right this rectangle
        if ((other.bottomLeft.getX() > this.topRight.getX()) || (other.topRight.getX() < this.bottomLeft.getX())) {
            skip = true;
        }

        if (!contains(other).isResult() && !isAdjacent(other) && !skip) {
            // Check if X is in range and then check the Y
            // test if this tr.x is in the range of the other rectangle's width x range bl.x to tr.x
            if ((this.topRight.getX() > other.bottomLeft.getX()) && (this.topRight.getX() < other.topRight.getX())) {
                if ((other.topRight.getY() <= this.topRight.getY()) && (other.bottomLeft.getY() >= this.bottomLeft.getY())) {
                    intersectsResult = true;
                }
                if ((other.topRight.getY() >= this.topRight.getY()) && (other.bottomLeft.getY() >= this.bottomLeft.getY())) {
                    intersectsResult = true;
                }
                if ((other.topRight.getY() >= this.topRight.getY()) && (other.bottomLeft.getY() <= this.bottomLeft.getY())) {
                    intersectsResult = true;
                }
            }
            if ((other.topRight.getX() > this.bottomLeft.getX()) && (other.topRight.getX() < this.topRight.getX())) {
                if ((other.topRight.getY() <= this.topRight.getY()) && (other.bottomLeft.getY() >= this.bottomLeft.getY())) {
                    intersectsResult = true;
                }
                if ((other.topRight.getY() >= this.topRight.getY()) && (other.bottomLeft.getY() >= this.bottomLeft.getY())) {
                    intersectsResult = true;
                }
                if ((other.topRight.getY() <= this.topRight.getY()) && (other.bottomLeft.getY() <= this.bottomLeft.getY())) {
                    intersectsResult = true;
                }
            }

            // Diagonal use case - right to left
            if ((this.topRight.getX() > other.bottomLeft.getX()) && (other.topRight.getX() >= this.topRight.getX())) {
                intersectsResult = true;
            }
        }

        String description = intersectsResult == true ? this + " intersects " + other : this + " does not intersect " + other;
        return new ShapeTestResult(intersectsResult, description);
    }

    public ShapeTestResult contains(Rectangle other) {
        boolean containsXAxis = false;
        boolean containsYAxis = false;
        // Check if x and y points of other rectangle are within this rectangle
        if ((other.bottomLeft.getX() >= this.bottomLeft.getX()) && (other.topRight.getX() <= this.topRight.getX())) {
            containsXAxis = true;
        }
        if ((other.bottomLeft.getY() >= this.bottomLeft.getY()) && (other.topRight.getY() <= this.topRight.getY())) {
            containsYAxis = true;
        }
        boolean containsResult = containsXAxis && containsYAxis;
        String description = containsResult == true ? this + " contains " + other : this + " does not contain " + other;
        return new ShapeTestResult(containsResult, description);
    }

    public boolean isAdjacent(Rectangle other) {
        return isAdjacentOnLeft(other).isResult() || isAdjacentOnRight(other).isResult() ||
                isAdjacentOnTop(other).isResult() || isAdjacentOnBottom(other).isResult();
    }

    public ShapeTestResult isAdjacentOnLeft(Rectangle other) {
        boolean result = false;
        String typeOfMatch = "";
        // check if the other rectangle is on the left
        if (other.bottomLeft.getX() == this.topRight.getX()) {
            if ((other.bottomLeft.getY() == this.bottomLeft.getY()) && (other.topRight.getY() == this.topRight.getY())) {
                typeOfMatch = "Proper";
                result = true;
            } else if ((other.bottomLeft.getY() > this.bottomLeft.getY()) && (other.topRight.getY() < this.topRight.getY())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.bottomLeft.getY() < this.bottomLeft.getY()) && (other.topRight.getY() > this.topRight.getY())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.bottomLeft.getY() > this.bottomLeft.getY()) || (other.topRight.getY() > this.topRight.getY())) {
                typeOfMatch = "Partial";
                result = true;
            }
        }
        String description = result == true ? this + " is adjacent (" + typeOfMatch + ") on left " + other : this + " is not adjacent on left " + other;
        return new ShapeTestResult(result, description);
    }

    public ShapeTestResult isAdjacentOnRight(Rectangle other) {
        boolean result = false;
        String typeOfMatch = "";
        // check if the other rectangle is on the right
        if (other.topRight.getX() == this.bottomLeft.getX()) {
            if ((other.topRight.getY() == this.topRight.getY()) && (other.bottomLeft.getY() == this.bottomLeft.getY())) {
                typeOfMatch = "Proper";
                result = true;
            } else if ((other.topRight.getY() < this.topRight.getY()) && (other.bottomLeft.getY() > this.bottomLeft.getY())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.topRight.getY() > this.topRight.getY()) && (other.bottomLeft.getY() < this.bottomLeft.getY())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.topRight.getY() > this.topRight.getY()) || (other.bottomLeft.getY() < this.bottomLeft.getY()) && !(other.topRight.getY() == this.bottomLeft.getY())) {
                typeOfMatch = "Partial";
                result = true;
            }
        }
        String description = result == true ? this + " is adjacent (" + typeOfMatch + ") on right " + other : this + " is not adjacent on right " + other;
        return new ShapeTestResult(result, description);
    }

    public ShapeTestResult isAdjacentOnTop(Rectangle other) {
        boolean result = false;
        String typeOfMatch = "";
        boolean skip = false;
        // skip test if other rectangle is pass this rectangle
        if (other.bottomLeft.getX() > this.topRight.getX()) {
            skip = true;
        }

        // check if the other rectangle is on top
        if ((other.bottomLeft.getY() == this.topRight.getY()) && !skip) {
            if ((other.bottomLeft.getX() == this.bottomLeft.getX()) && (other.topRight.getX() == this.topRight.getX())) {
                typeOfMatch = "Proper";
                result = true;
            } else if ((other.bottomLeft.getX() > this.bottomLeft.getX()) && (other.topRight.getX() < this.topRight.getX())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.bottomLeft.getX() < this.bottomLeft.getX()) && (other.topRight.getX() > this.topRight.getX())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.bottomLeft.getX() > this.bottomLeft.getX()) || (other.topRight.getX() > this.topRight.getX())) {
                typeOfMatch = "Partial";
                result = true;
            }
        }
        String description = result == true ? this + " is adjacent (" + typeOfMatch + ") on top " + other : this + " is not adjacent on top " + other;
        return new ShapeTestResult(result, description);
    }

    public ShapeTestResult isAdjacentOnBottom(Rectangle other) {
        boolean result = false;
        String typeOfMatch = "";
        boolean skip = false;
        // skip test if other rectangle is below this rectangle
        if (other.topRight.getY() < this.bottomLeft.getY()) {
            skip = true;
        }
        // skip test if other rectangle is at corner of this rectangle
        if ((other.topRight.getY() == this.bottomLeft.getY()) && (other.bottomLeft.getX() == this.topRight.getX())) {
            skip = true;
        }

        // check if the other rectangle is on bottom
        if ((other.topRight.getY() == this.bottomLeft.getY()) && !skip) {
            if ((other.topRight.getX() == this.topRight.getX()) && (other.bottomLeft.getX() == this.bottomLeft.getX())) {
                typeOfMatch = "Proper";
                result = true;
            } else if ((other.topRight.getX() < this.topRight.getX()) && (other.bottomLeft.getX() > this.bottomLeft.getX())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.topRight.getX() > this.topRight.getX()) && (other.bottomLeft.getX() < this.bottomLeft.getX())) {
                typeOfMatch = "SubLine";
                result = true;
            } else if ((other.topRight.getX() > this.topRight.getX()) || (other.bottomLeft.getX() > this.bottomLeft.getX())) {
                typeOfMatch = "Partial";
                result = true;
            }
        }
        String description = result == true ? this + " is adjacent (" + typeOfMatch + ") on bottom " + other : this + " is not adjacent on bottom " + other;
        return new ShapeTestResult(result, description);
    }
}
