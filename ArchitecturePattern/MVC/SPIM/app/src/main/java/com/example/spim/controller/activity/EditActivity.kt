package com.example.spim.controller.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.spim.databinding.ActivityEditBinding
import com.example.spim.model.DTO.UserDTO

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    companion object {
        lateinit var user: UserDTO;
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEdit.setOnClickListener {
            if(emptyCheck()) {
                user = UserDTO(binding.etName.text.toString(), binding.etGrade.text.toString(),
                    binding.etClass.text.toString(), binding.etNumber.text.toString())
                finish()
            } else {
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun emptyCheck(): Boolean {
        if(binding.etClass.text.isNotEmpty() && binding.etGrade.text.isNotEmpty()
            && binding.etName.text.isNotEmpty() && binding.etNumber.text.isNotEmpty()) {
            return true
        }

        return false
    }
}