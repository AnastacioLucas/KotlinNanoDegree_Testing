package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert
import org.junit.Assert
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsZeroHundred(){
        val tasks = listOf<Task>(
            Task("title", "description", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)

        MatcherAssert.assertThat(result.completedTasksPercent, `is`(0f))
        MatcherAssert.assertThat(result.activeTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_both_returnFortySixty(){
        val tasks = listOf<Task>(
            Task("title", "description", isCompleted = true),
            Task("title", "description", isCompleted = true),
            Task("title", "description", isCompleted = false),
            Task("title", "description", isCompleted = false),
            Task("title", "description", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)

        Assert.assertEquals(40f, result.completedTasksPercent)
        Assert.assertEquals(60f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros(){
        val tasks = listOf<Task>()

        val result = getActiveAndCompletedStats(tasks)

        Assert.assertEquals(0f, result.completedTasksPercent)
        Assert.assertEquals(0f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros(){
        val tasks = null

        val result = getActiveAndCompletedStats(tasks)

        Assert.assertEquals(0f, result.completedTasksPercent)
        Assert.assertEquals(0f, result.activeTasksPercent)
    }
}