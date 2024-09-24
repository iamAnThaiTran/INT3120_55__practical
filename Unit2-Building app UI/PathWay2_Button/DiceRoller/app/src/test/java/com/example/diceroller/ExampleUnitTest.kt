package com.example.diceroller

import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 */
class Square (var dai: Int, var rong: Int) {
    fun funtion2Test(): Int {
        return dai - rong
    }

    fun setVal(a: Int, b: Int) {
        dai = a
        rong = b
    }
}
class ExampleUnitTest {

    companion object {
        private lateinit var exampleSquare: Square
        @Before
        fun setUp() {
            exampleSquare = Square(20, 30)
        }

        @After
        fun clear() {
            exampleSquare.setVal(60, 50)
        }
    }
    @Test
    fun daiLonHonRong() {
        assertTrue(exampleSquare.funtion2Test() > 0)
    }
}