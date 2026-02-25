package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean("board1",Board.class);
        board.getDoneList().addTask("Genocide");
        board.getInProgressList().addTask("Conquering world");
        board.getToDoList().addTask("Buy milk");

        assertEquals("Genocide", board.getDoneList().getTaskList().getFirst());
        assertEquals("Conquering world", board.getInProgressList().getTaskList().getFirst());
        assertEquals("Buy milk", board.getToDoList().getTaskList().getFirst());
    }
}
