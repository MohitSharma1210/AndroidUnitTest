package com.example.androidunittest.utlis

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizedExample(val inputString: String, val expectedvalue:Boolean) {

    @Test
    fun test(){
        val helper = Helper()
        val result = helper.isPallindrome(inputString)
        assertEquals(expectedvalue,result)
    }

    companion object{

        @JvmStatic
        @Parameterized.Parameters(name = "index : {0} is pallindrome - {1}")
        fun data(): List<Array<Any>>{
            return listOf(
                arrayOf("hello", false),
                arrayOf("level",true),
                arrayOf("a",true),
                arrayOf("",true)
            )
        }
    }
}