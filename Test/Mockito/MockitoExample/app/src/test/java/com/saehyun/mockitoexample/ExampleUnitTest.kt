package com.saehyun.mockitoexample

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

    @Test
    fun example1() {
        val example = Mockito.mock(Example::class.java)

        Mockito.`when`(example.getId()).thenReturn(100)
        Mockito.`when`(example.getUrl(100)).thenReturn("example")

        assertEquals(100, example.getId())
        assertEquals("example", example.getUrl(example.getId()))
    }
}