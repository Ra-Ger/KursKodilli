package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Objects;

public class ForumUser {
    private int ID;
    private String name;
    private char sex;
    private LocalDate birthDate;
    private int publishedPostsCount = 0;

    public ForumUser(int ID, String name, char sex, LocalDate birthDate) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public void postWasPublished()
    {
        publishedPostsCount++;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        return ID == forumUser.ID && sex == forumUser.sex && Objects.equals(name, forumUser.name) && Objects.equals(birthDate, forumUser.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, sex, birthDate);
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", publishedPostsCount=" + publishedPostsCount +
                '}';
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPublishedPostsCount() {
        return publishedPostsCount;
    }
}
