package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryDrivingTask() {
        TaskFactory taskFactory = new TaskFactory();
        Task task = taskFactory.makeTask(TaskFactory.DRIVINGTASK);
        assertEquals("Helicopter trip",task.getTaskName());
    }

    @Test
    void testFactoryPaintingTask() {
        TaskFactory taskFactory = new TaskFactory();
        Task task = taskFactory.makeTask(TaskFactory.PAINTINGTASK);
        assertEquals("Animal fur dying",task.getTaskName());
    }

    @Test
    void testFactoryShoppingTask() {
        TaskFactory taskFactory = new TaskFactory();
        Task task = taskFactory.makeTask(TaskFactory.SHOPPINGTASK);
        assertEquals("Basic necessities",task.getTaskName());
    }

    @Test
    void testFactoryShoppingTaskCompleted() {
        TaskFactory taskFactory = new TaskFactory();
        Task task = taskFactory.makeTask(TaskFactory.SHOPPINGTASK);
        task.executeTask();
        assertEquals(true,task.isTaskExecuted());
    }
}
