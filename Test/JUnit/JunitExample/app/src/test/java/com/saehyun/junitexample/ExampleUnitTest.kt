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

}