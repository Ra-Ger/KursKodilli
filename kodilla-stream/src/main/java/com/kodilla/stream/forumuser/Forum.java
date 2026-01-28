package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    public static List<ForumUser> getUserList()
    {
        List<ForumUser> listOfUsers = new ArrayList<>();
        listOfUsers.add(new ForumUser(0,"Edmund Hohol",'M',LocalDate.of(1990,12,10)));
        listOfUsers.add(new ForumUser(1,"Zbyslaw Arhi",'M',LocalDate.of(1995,10,4)));
        listOfUsers.add(new ForumUser(2,"Arthur Mcconnor",'M',LocalDate.of(1996,4,23)));
        listOfUsers.add(new ForumUser(3,"Anais Waterson",'F',LocalDate.of(1981,10,4)));
        listOfUsers.add(new ForumUser(4,"Adolf Montana",'M',LocalDate.of(2015,10,4)));

        listOfUsers.get(0).postWasPublished();
        listOfUsers.get(2).postWasPublished();

        return new ArrayList<>(listOfUsers);
    }
}
