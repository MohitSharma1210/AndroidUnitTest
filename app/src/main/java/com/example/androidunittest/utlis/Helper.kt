package com.example.androidunittest.utlis

class Helper {

    fun isPallindrome(input: String): Boolean{
        var i=0;
        var j = input.length-1;
        while (i<j){
            if (input[i] != input[j])
                return false
            i++
            j--
        }
        return true
    }
}