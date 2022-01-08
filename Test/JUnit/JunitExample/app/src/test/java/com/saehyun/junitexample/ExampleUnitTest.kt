package com.saehyun.junitexample

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private lateinit var calculator: Calculator

    @Before
    fun init() {
        calculator = Calculator()
    }

    @Test
    fun addValue_test() {
        assertEquals(52, calculator.addValue(50, 2))
        assertEquals(52, calculator.addValue(50, 1))
    }

    @Test
    fun addArray_test() {
        var arr : Array<Int> = arrayOf(1, 2, 3, 4)
        var ret : Array<Int> = arrayOf(4, 5, 6, 7)

        assertArrayEquals(ret, calculator.addArray(arr, 3))
        assertArrayEquals(ret, calculator.addArray(arr, 30))
    }

}