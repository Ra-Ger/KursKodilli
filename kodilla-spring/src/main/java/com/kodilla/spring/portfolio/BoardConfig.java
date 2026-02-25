package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Bean(name = "list1")
    @Scope("prototype")
    public TaskList getTaskListFirst()
    {
        return new TaskList();
    }

    @Bean(name = "list2")
    @Scope("prototype")
    public TaskList getTaskListSecond()
    {
        return new TaskList();
    }

    @Bean(name = "list3")
    @Scope("prototype")
    public TaskList getTaskListThird()
    {
        return new TaskList();
    }

    @Bean(name = "board1")
    public Board getBoardFirst()
    {
        return new Board(getTaskListFirst(),getTaskListSecond(),getTaskListThird());
    }

}
