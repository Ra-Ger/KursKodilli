package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    void testFindByListName()
    {
        TaskList taskList = new TaskList("Doing Stuff", DESCRIPTION);
        taskListDao.save(taskList);

        List<TaskList> readTaskList = taskListDao.findByListName("Doing Stuff");

        assertEquals(1, readTaskList.size());

        int id = readTaskList.get(0).getId();
        taskListDao.deleteById(id);
    }
}
