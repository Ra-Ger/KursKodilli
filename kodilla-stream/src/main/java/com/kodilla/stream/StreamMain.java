package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        Map<Integer,ForumUser> usersMap = Forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> Period.between(forumUser.getBirthDate(), LocalDate.now()).getYears() >= 20)
                .filter(forumUser -> forumUser.getPublishedPostsCount() > 0)
                .collect(Collectors.toMap(ForumUser::getID, forumUser -> forumUser));

        System.out.println("# elements: " + usersMap.size());
        usersMap.entrySet().stream()
                .map(entry -> entry.getValue().toString())
                .forEach(System.out::println);
    }
}