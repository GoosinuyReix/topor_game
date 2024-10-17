package com.example.topor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.topor.databinding.ActivityMainBinding
import kotlin.random.Random
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var right_answer = Random.nextInt(1,4)
        var my_answer:Int
        binding.firstTopor.setOnClickListener {
            my_answer = 1
            checkAnswer(my_answer, right_answer, binding)
            right_answer = Random.nextInt(1,4)
        }
        binding.secondTopor.setOnClickListener{
            my_answer = 2
            checkAnswer(my_answer, right_answer, binding)
            right_answer = Random.nextInt(1,4)
        }
        binding.thirdTopor.setOnClickListener{
            my_answer = 3
            checkAnswer(my_answer, right_answer, binding)
            right_answer = Random.nextInt(1,4)
        }
    }
    private fun checkAnswer(my_answer: Int, right_answer: Int, binding: ActivityMainBinding) {
        if (my_answer == right_answer) {
            binding.myToporTxt.text = "Вы выбрали правильный топор!!!"
            binding.myToporTxt.visibility = View.VISIBLE
            binding.rightToporTxt.visibility = View.INVISIBLE
        } else {
            binding.myToporTxt.text = "Вы выбрали плохой топор :("
            binding.rightToporTxt.text = "Правильный топор был $right_answer"
            binding.myToporTxt.visibility = View.VISIBLE
            binding.rightToporTxt.visibility = View.VISIBLE
        }
    }
}