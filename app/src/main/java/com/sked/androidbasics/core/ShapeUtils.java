package com.sked.androidbasics.core;

/**
 * Created by manish on 10/15/2015.
 */
public class ShapeUtils {
    //Method to calculate the shape property
    public static float shapeProperty(TwoDimensionalShape shape) {
        return shape.getPerimeter() / shape.getArea();
    }
}
