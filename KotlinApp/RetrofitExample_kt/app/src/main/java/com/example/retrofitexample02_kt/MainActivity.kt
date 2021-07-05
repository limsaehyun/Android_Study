package com.example.retrofitexample02_kt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.retrofitexample02_kt.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var responseValue:MealResponse
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener {
            if(!binding.etDate.text.isNullOrBlank()) {
                readMeal(binding.etDate.text.toString())
            }
        }
    }

    private fun readMeal(data:String) {
        val apiProvider = ApiProvider.getInstance().create(MealApi::class.java)
        apiProvider.getMeal(data).enqueue(object : Callback<MealResponse> {
            override fun onResponse(call: Call<MealResponse>, response: Response<MealResponse>) {
                if(response.isSuccessful) {
                    responseValue = response.body()!!
                    setMeal(responseValue)
                }
            }

            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
            }

        })
    }

    private fun setMeal(mealResponse: MealResponse) {
        var mealView_breakfast = "<아침>\n"
        var mealView_lunch = "<점심>\n"
        var mealView_dinner = "<저녁>\n"

        for(i in mealResponse.breakfast) {
            mealView_breakfast +="$i\n"
        }
        for(i in mealResponse.lunch) {
            mealView_lunch +="$i\n"
        }
        for(i in mealResponse.dinner) {
            mealView_dinner +="$i\n"
        }
        binding.tvBreakfast.text = mealView_breakfast
        binding.tvLunch.text = mealView_lunch
        binding.tvDinner.text = mealView_dinner
    }
}