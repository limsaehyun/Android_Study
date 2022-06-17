package com.saehyun.mvi_with_orbit_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.saehyun.mvi_with_orbit_example.databinding.ActivityMainBinding
import org.orbitmvi.orbit.viewmodel.observe

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var vm: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        vm = ViewModelProvider(this).get(CalculatorViewModel::class.java)

        binding.btnAdd.setOnClickListener {
            vm.add(1)
        }

        binding.btnAdd.setOnClickListener { vm.add(1) }

        vm.observe(
            this,
            state = ::render,
            sideEffect = ::handleSideEffect
        )
    }

    private fun render(state: CalculatorState) {
        binding.textView.text = state.total.toString()
    }

    private fun handleSideEffect(sideEffect: CalculatorSideEffect) {
        when(sideEffect) {
            is CalculatorSideEffect.Toast -> Toast.makeText(applicationContext, sideEffect.text, Toast.LENGTH_SHORT).show()
        }
    }
}