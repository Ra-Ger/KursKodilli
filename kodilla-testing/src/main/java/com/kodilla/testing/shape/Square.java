package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements IShape
{
    private double side = 0;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public String getShapeName() {
        return "square";
    }

    @Override
    public double getField() {
        return Math.pow(side,2);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(side, square.side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(side);
    }
}
