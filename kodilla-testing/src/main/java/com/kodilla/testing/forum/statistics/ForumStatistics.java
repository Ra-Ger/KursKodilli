package com.kodilla.testing.forum.statistics;

import java.util.List;

public class ForumStatistics implements Statistics{

    Statistics statistics;

    private float averagePostsPerUser = 0;
    private float averageCommentsPerUser = 0;
    private float averageCommentsPerPost = 0;

    public ForumStatistics(Statistics statistics)
    {
        this.statistics = statistics;
    }

    @Override
    public List<String> usersNames() {
        return statistics.usersNames();
    }

    @Override
    public int postsCount() {
        return statistics.postsCount();
    }

    @Override
    public int commentsCount() {
        return statistics.commentsCount();
    }

    public void calculateAdvStatistics(Statistics statistics)
    {
        averagePostsPerUser = (usersNames().isEmpty()) ? 0 : (float) postsCount() /usersNames().size();
        averageCommentsPerUser = (usersNames().isEmpty()) ? 0 : (float) commentsCount()/usersNames().size();
        averageCommentsPerPost = (postsCount() == 0) ? 0 :(float) commentsCount()/postsCount();
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

