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
        var percent:Double
        var count_of_clicks = 0
        var right_clicks = 0
        var check:Boolean
        binding.firstTopor.setOnClickListener {
            my_answer = 1
            count_of_clicks++
            check = checkAnswer(my_answer, right_answer, binding)
            right_answer = Random.nextInt(1,4)
            if(check) right_clicks++
            percent = (right_clicks.toDouble() / count_of_clicks.toDouble()) * 100.0
            binding.percentTxt.text = String.format("Процент правильных ответов равен %.2f%%", percent)
            binding.percentTxt.visibility = View.VISIBLE
        }
        binding.secondTopor.setOnClickListener{
            my_answer = 2
            count_of_clicks++
            check = checkAnswer(my_answer, right_answer, binding)
            right_answer = Random.nextInt(1,4)
            if(check) right_clicks++
            percent = (right_clicks.toDouble() / count_of_clicks.toDouble()) * 100.0
            binding.percentTxt.text = String.format("Процент правильных ответов равен %.2f%%", percent)
            binding.percentTxt.visibility = View.VISIBLE
        }

        binding.thirdTopor.setOnClickListener{
            my_answer = 3
            count_of_clicks++
            check = checkAnswer(my_answer, right_answer, binding)
            right_answer = Random.nextInt(1,4)
            if(check) right_clicks++
            percent = (right_clicks.toDouble() / count_of_clicks.toDouble()) * 100.0
            binding.percentTxt.text = String.format("Процент правильных ответов равен %.2f%%", percent)
            binding.percentTxt.visibility = View.VISIBLE
        }
    }
    private fun checkAnswer(my_answer: Int, right_answer: Int, binding: ActivityMainBinding):Boolean {
        if (my_answer == right_answer) {
            binding.myToporTxt.text = "Вы выбрали правильный топор!!!"
            binding.myToporTxt.visibility = View.VISIBLE
            binding.rightToporTxt.visibility = View.INVISIBLE
            return true
        } else {
            binding.myToporTxt.text = "Вы выбрали плохой топор :("
            binding.rightToporTxt.text = "Правильный топор был $right_answer"
            binding.myToporTxt.visibility = View.VISIBLE
            binding.rightToporTxt.visibility = View.VISIBLE
            return false
        }
    }
}