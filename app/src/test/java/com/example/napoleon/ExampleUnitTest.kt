package com.example.napoleon

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    fun formatPrice(arg1: Int = 123, arg2: String = "kg", arg3: Int =5): String = "Tovare price - $arg1/$arg2, skidka - $arg3"


    fun addition_fun(){
        print(message = formatPrice())
    }
}