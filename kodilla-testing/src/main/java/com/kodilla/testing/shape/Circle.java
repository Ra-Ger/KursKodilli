package com.kodilla.testing.shape;

import java.util.Objects;

public class Circle implements  IShape{

    private double ray = 0;

    public Circle(double ray) {
        this.ray = ray;
    }

    @Override
    public String getShapeName() {
        return "circle";
    }

    @Override
    public double getField() {
        return Math.PI * Math.pow(ray,2);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(ray, circle.ray) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ray);
    }
}
