package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements IShape{

    private double height = 0;
    private double base = 0;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public String getShapeName() {
        return "triangle";
    }

    @Override
    public double getField() {
        return 0.5*height*base;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(height, triangle.height) == 0 && Double.compare(base, triangle.base) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, base);
    }
}
