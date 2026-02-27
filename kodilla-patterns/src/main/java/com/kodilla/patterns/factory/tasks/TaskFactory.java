package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.*;

public class TaskFactory {

    public static final String DRIVINGTASK = "DRIVINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";
    public static final String SHOPPINGTASK = "SHOPPINGTASK";

    public final Task makeTask(final String taskClass) {
        return switch (taskClass) {
            case DRIVINGTASK -> new DrivingTask("Helicopter trip", "Pokrowsk","Mi-25");
            case PAINTINGTASK -> new PaintingTask("Animal fur dying", "Pink","Dog");
            case SHOPPINGTASK -> new ShoppingTask("Basic necessities", "Enriched uranium", 5000);
            default -> null;
        };
    }
}
