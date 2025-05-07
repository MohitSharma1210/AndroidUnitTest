package com.example.androidunittest.utlis

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    lateinit var helper: Helper

    @Before
    fun setUp(){
        helper = Helper()
        println("Before every test case")
    }

    @After
    fun tearDowp(){
        println("After every test case")
    }

    @Test
    fun isPallindrome() {
        // Act
        val result = helper.isPallindrome("")
        // Assert
        assertEquals(true, result)
    }

    @Test
    fun isPallindrome_inputString_level_expectedTrue() {
        // Act
        val result = helper.isPallindrome("a")
        // Assert
        assertEquals(true, result)
    }
}