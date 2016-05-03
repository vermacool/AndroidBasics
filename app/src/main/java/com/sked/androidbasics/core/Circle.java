package com.sked.androidbasics.core;

import android.graphics.Point;

/**
 * Created by manish on 10/15/2015.
 */
public class Circle extends TwoDimensionalShape {
    private float radius;
    private Point center;

    public Circle(float radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    float getArea() {
        return (float) (Math.PI * radius * radius);
    }

    @Override
    float getPerimeter() {
        return (float) (2 * Math.PI * radius);
    }


    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }
}
