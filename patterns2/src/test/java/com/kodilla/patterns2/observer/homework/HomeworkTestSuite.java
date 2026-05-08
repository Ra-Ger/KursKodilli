package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

 class HomeworkTestSuite {

    @Test
     void testUpdateJohn() {
        // Given
        TasksQueue mark = new MarkStalionTaskQueue();
        TasksQueue adolf = new AdolfReltihTaskQueue();
        Mentor johnSmith = new Mentor("John Smith");
        mark.registerObserver(johnSmith);
        adolf.registerObserver(johnSmith);

        // When
        mark.addTask("Complicated task.");
        mark.addTask("Project: Flying penguin");
        adolf.addTask("Command and conquer");
        adolf.addTask("Project: epic furry");

        // Then
        assertEquals(4, johnSmith.getUpdateCount());
    }

     @Test
     void testUpdateIvone() {
         // Given
         TasksQueue adolf = new AdolfReltihTaskQueue();
         Mentor johnSmith = new Mentor("John Smith");
         Mentor ivoneEscobar= new Mentor("Ivone Escobar");
         adolf.registerObserver(ivoneEscobar);

         // When
         adolf.addTask("Command and conquer");
         adolf.addTask("Project: epic furry");

         // Then
         assertEquals(2, ivoneEscobar.getUpdateCount());
     }
}
