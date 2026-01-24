package com.kodilla.testing.forum.statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;
    ForumStatistics forumStatistics;

    @BeforeEach
    public void beforeEveryTest() {
         forumStatistics = new ForumStatistics(statisticsMock);
        when(statisticsMock.postsCount()).thenReturn(20);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(List.of("elo","jolo","rotfl","bongo","kotas","koka","mara","HaruChan","Legosi","twojStary123"));
    }

    @Test
    void test0Posts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(0);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(0, forumStatistics.getAverageCommentsPerPost(), 0.001);
        assertEquals(0, forumStatistics.getAveragePostsPerUser(), 0.001);
        assertEquals(10, forumStatistics.getAverageCommentsPerUser(), 0.001);
    }

    @Test
    void test1000Posts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(0.1, forumStatistics.getAverageCommentsPerPost(), 0.001);
        assertEquals(100, forumStatistics.getAveragePostsPerUser(), 0.001);
        assertEquals(10, forumStatistics.getAverageCommentsPerUser(), 0.001);
    }

    @Test
    void test0Comments() {
        // Given
        when(statisticsMock.commentsCount()).thenReturn(0);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(0, forumStatistics.getAverageCommentsPerPost(), 0.001);
        assertEquals(2, forumStatistics.getAveragePostsPerUser(), 0.001);
        assertEquals(0, forumStatistics.getAverageCommentsPerUser(), 0.001);
    }

    @Test
    void testWhenCommentsLessThanPosts() {
        // Given
        when(statisticsMock.commentsCount()).thenReturn(10);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(0.5, forumStatistics.getAverageCommentsPerPost(), 0.001);
        assertEquals(2, forumStatistics.getAveragePostsPerUser(), 0.001);
        assertEquals(1, forumStatistics.getAverageCommentsPerUser(), 0.001);
    }

    @Test
    void testWhenCommentsMoreThanPosts() {
        // Given
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(5, forumStatistics.getAverageCommentsPerPost(), 0.001);
        assertEquals(2, forumStatistics.getAveragePostsPerUser(), 0.001);
        assertEquals(10, forumStatistics.getAverageCommentsPerUser(), 0.001);
    }

    @Test
    void test0Users() {
        // Given
        when(statisticsMock.usersNames()).thenReturn(new ArrayList<>());
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(5, forumStatistics.getAverageCommentsPerPost(), 0.001);
        assertEquals(0, forumStatistics.getAveragePostsPerUser(), 0.001);
        assertEquals(0, forumStatistics.getAverageCommentsPerUser(), 0.001);
    }

    @Test
    void test100Users() {
        // Given
        List<String> userList = new ArrayList<>();
        for(int i = 0; i < 100; i++)
        {
            userList.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(userList);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(5, forumStatistics.getAverageCommentsPerPost(), 0.001);
        assertEquals(0.2, forumStatistics.getAveragePostsPerUser(), 0.001);
        assertEquals(1, forumStatistics.getAverageCommentsPerUser(), 0.001);
    }
}
