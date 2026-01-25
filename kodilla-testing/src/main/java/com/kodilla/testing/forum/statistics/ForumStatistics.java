package com.kodilla.testing.forum.statistics;

import java.util.List;

public class ForumStatistics{

    private float averagePostsPerUser = 0;
    private float averageCommentsPerUser = 0;
    private float averageCommentsPerPost = 0;

    public void calculateAdvStatistics(Statistics statistics)
    {
        averagePostsPerUser = (statistics.usersNames().isEmpty()) ? 0 : (float) statistics.postsCount() /statistics.usersNames().size();
        averageCommentsPerUser = (statistics.usersNames().isEmpty()) ? 0 : (float) statistics.commentsCount()/statistics.usersNames().size();
        averageCommentsPerPost = (statistics.postsCount() == 0) ? 0 :(float) statistics.commentsCount()/statistics.postsCount();
    }

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

