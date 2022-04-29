package com.khera;

import lombok.Data;

@Data
public class Rectangle extends Shape implements RectangleFunctions {

    private final Point bottomLeft;
    private final Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
        this.name = "Rectangle";
    }

}
