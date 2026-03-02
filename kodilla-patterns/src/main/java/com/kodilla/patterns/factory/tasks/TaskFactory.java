package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.*;

public class TaskFactory {

    public static final String DRIVINGTASK = "DRIVINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";
    public static final String SHOPPINGTASK = "SHOPPINGTASK";

    public final Task makeTask(final String taskClass, String taskName, String param1, String param2, double quantity) {
        return switch (taskClass) {
            case DRIVINGTASK -> new DrivingTask(taskName, param1,param2);
            case PAINTINGTASK -> new PaintingTask(taskName, param1,param2);
            case SHOPPINGTASK -> new ShoppingTask(taskName, param1, quantity);
            default -> throw new IllegalArgumentException();
        };
    }
}
