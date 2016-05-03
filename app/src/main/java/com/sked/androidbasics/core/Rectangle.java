package com.sked.androidbasics.core;

/**
 * Created by manish on 10/15/2015.
 */
public class Rectangle extends TwoDimensionalShape {
    private float width;

    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    private float height;

    @Override
    float getArea() {
        return width * height;
    }

    @Override
    float getPerimeter() {
        return 2 * (height + width);
    }
}
