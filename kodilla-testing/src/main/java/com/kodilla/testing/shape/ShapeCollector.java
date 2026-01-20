package com.kodilla.testing.shape;

import java.util.*;

public class ShapeCollector {

    private List<IShape> shapeList = new ArrayList<IShape>();

    public ShapeCollector(List<IShape> shapeList) {
        this.shapeList = shapeList;
    }

    public void addFigure(IShape shape)
    {
        shapeList.add(shape);
    }
    public void removeFigure(IShape shape)
    {
        shapeList.remove(shape);
    }
    public IShape getFigure(int n)
    {
        try {
            return shapeList.get(n);
        }
        catch(Exception e) {
            System.out.println("Out of index!");
            return null;
        }
    }
    public String showFigures()
    {
        if(shapeList.isEmpty())
            return "No shapes in collection.";

        String output = "";
        for(IShape s : shapeList)
        {
            output += s.getShapeName() + ", ";
        }
        return  output;
    }
}
