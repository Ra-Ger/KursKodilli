package com.kodilla.testing.forum.statistics;

import java.util.List;

public class ForumStatistics{

    private int postsCount = 0;
    private int usersCount = 0;
    private int commentsCount = 0;
    private double averagePostsPerUser = 0;
    private double averageCommentsPerUser = 0;
    private double averageCommentsPerPost = 0;

    public void calculateAdvStatistics(Statistics statistics)
    {
        postsCount = statistics.postsCount();
        usersCount = statistics.usersNames().size();
        commentsCount = statistics.commentsCount();
        averagePostsPerUser = (usersCount == 0) ? 0 : (double) postsCount /usersCount;
        averageCommentsPerUser = (usersCount == 0) ? 0 : (double) commentsCount/usersCount;
        averageCommentsPerPost = (postsCount == 0) ? 0 :(double) commentsCount/postsCount;
    }

    public int getPostsCount() { return postsCount; }
    public int getCommentsCount() { return commentsCount; }
    public int getUsersCount() { return usersCount; }
    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }
    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }
    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}

