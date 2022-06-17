package com.saehyun.mvi_with_orbit_example

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class CalculatorViewModel :
    ContainerHost<CalculatorState, CalculatorSideEffect>, ViewModel() {

    override val container = container<CalculatorState, CalculatorSideEffect>(CalculatorState())

    fun add(num: Int) = intent {
        if(state.total == 9) {
            postSideEffect(
                CalculatorSideEffect.Toast("success")
            )
        }

        reduce {
            state.copy(total = state.total + num)
        }
    }
}