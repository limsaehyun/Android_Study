package com.saehyun.mvi_with_orbit_example

sealed class CalculatorSideEffect {
    data class Toast(val text: String): CalculatorSideEffect()
}