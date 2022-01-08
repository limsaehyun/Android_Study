package com.saehyun.junitexample

class Calculator {


    fun addValue(a: Int, b: Int) : Int {
        return a + b
    }

    fun addArray(arr: Array<Int>, a: Int) : Array<Int> {
        for(i:Int in 0..arr.size) {
            arr[i] += a
        }
        return arr
    }

}