package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryDrivingTask() {
        TaskFactory taskFactory = new TaskFactory();
        Task task = taskFactory.makeTask(TaskFactory.DRIVINGTASK,"Helicopter trip","Telaviw","Helicopter",0);
        assertEquals("Helicopter trip",task.getTaskName());
    }

    @Test
    void testFactoryPaintingTask() {
        TaskFactory taskFactory = new TaskFactory();
        Task task = taskFactory.makeTask(TaskFactory.PAINTINGTASK,"Animal fur dying","Pink","Dog",0);
        assertEquals("Animal fur dying",task.getTaskName());
    }

    @Test
    void testFactoryShoppingTask() {
        TaskFactory taskFactory = new TaskFactory();
        Task task = taskFactory.makeTask(TaskFactory.SHOPPINGTASK,"Shopping","Milk","",2);
        assertEquals("Shopping",task.getTaskName());
    }

    @Test
    void testFactoryShoppingTaskCompleted() {
        TaskFactory taskFactory = new TaskFactory();
        Task task = taskFactory.makeTask(TaskFactory.SHOPPINGTASK,"Shopping","Milk","",2);
        task.executeTask();
        assertEquals(true,task.isTaskExecuted());
    }
}
