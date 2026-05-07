package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeworkTestSuite {

    @Test
    public void testUpdate() {
        // Given
        TasksQueue Mark = new MarkStalionTaskQueue();
        TasksQueue Adolf = new AdolfReltihTaskQueue();
        Mentor johnSmith = new Mentor("John Smith");
        Mentor ivoneEscobar= new Mentor("Ivone Escobar");
        Mark.registerObserver(johnSmith);
        Adolf.registerObserver(ivoneEscobar);
        // When
        Mark.addTask("Complicated task.");
        Mark.addTask("Project: Flying penguin");
        Adolf.addTask("Command and conquer");
        Adolf.addTask("Project: epic furry");
        // Then
        assertEquals(2, johnSmith.getUpdateCount());
        assertEquals(2, ivoneEscobar.getUpdateCount());
    }
}
