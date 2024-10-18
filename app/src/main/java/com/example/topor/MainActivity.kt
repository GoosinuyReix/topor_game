package com.example.topor

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.topor.databinding.ActivityMainBinding
import kotlin.random.Random
import android.view.View
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var right_answer = Random.nextInt(1, 4)
        var my_answer: Int
        var percent: Double
        var count_of_clicks = 0
        var right_clicks = 0
        var check: Boolean
        binding.firstTopor.setOnClickListener {
            my_answer = 1
            count_of_clicks++
            check = checkAnswer(my_answer, right_answer, binding)
            if (check) {
                right_clicks++
                highlightCorrectAnswer(binding, my_answer, right_answer, true)
            }
            else{
                highlightCorrectAnswer(binding, my_answer, right_answer, false)
            }
            percent = (right_clicks.toDouble() / count_of_clicks.toDouble()) * 100.0
            binding.percentTxt.text =
                String.format("Процент правильных ответов равен %.2f%%", percent)
            binding.percentTxt.visibility = View.VISIBLE
            Timer().schedule(400){
                resetButtonColors(binding);
            }
            right_answer = Random.nextInt(1, 4)
        }
        binding.secondTopor.setOnClickListener {
            my_answer = 2
            count_of_clicks++
            check = checkAnswer(my_answer, right_answer, binding)
            if (check) {
                right_clicks++
                highlightCorrectAnswer(binding, my_answer, right_answer, true)
            }
            else{
                highlightCorrectAnswer(binding, my_answer, right_answer, false)
            }
            percent = (right_clicks.toDouble() / count_of_clicks.toDouble()) * 100.0
            binding.percentTxt.text = String.format("Процент правильных ответов равен %.2f%%", percent)
            binding.percentTxt.visibility = View.VISIBLE
            Timer().schedule(400){
                resetButtonColors(binding);
            }
            right_answer = Random.nextInt(1, 4)
        }

        binding.thirdTopor.setOnClickListener {
            my_answer = 3
            count_of_clicks++
            check = checkAnswer(my_answer, right_answer, binding)
            if (check) {
                right_clicks++
                highlightCorrectAnswer(binding, my_answer, right_answer, true)
            }
            else{
                highlightCorrectAnswer(binding, my_answer, right_answer, false)
            }
            percent = (right_clicks.toDouble() / count_of_clicks.toDouble()) * 100.0
            binding.percentTxt.text = String.format("Процент правильных ответов равен %.2f%%", percent)
            binding.percentTxt.visibility = View.VISIBLE
            Timer().schedule(400){
                resetButtonColors(binding);
            }
            right_answer = Random.nextInt(1, 4)
        }

        binding.restartBtn.setOnClickListener {
            count_of_clicks = 0
            right_clicks = 0
            binding.percentTxt.text = "Процент правильных ответов равен 0%"
            binding.myToporTxt.visibility = View.INVISIBLE
            binding.rightToporTxt.visibility = View.INVISIBLE
            binding.percentTxt.visibility = View.INVISIBLE
        }
    }

    private fun checkAnswer(
        my_answer: Int,
        right_answer: Int,
        binding: ActivityMainBinding
    ): Boolean {
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

    private fun highlightCorrectAnswer(
        binding: ActivityMainBinding,
        my_answer: Int,
        right_answer: Int,
        isCorrect: Boolean
    ) {
        allColorsRed(binding)

        if (isCorrect) {
            when (right_answer) {
                1 -> binding.firstTopor.setBackgroundColor(Color.GREEN)
                2 -> binding.secondTopor.setBackgroundColor(Color.GREEN)
                3 -> binding.thirdTopor.setBackgroundColor(Color.GREEN)
            }
        } else {
            when (my_answer) {
                1 -> binding.firstTopor.setBackgroundColor(Color.RED)
                2 -> binding.secondTopor.setBackgroundColor(Color.RED)
                3 -> binding.thirdTopor.setBackgroundColor(Color.RED)
            }
            when (right_answer) {
                1 -> binding.firstTopor.setBackgroundColor(Color.GREEN)
                2 -> binding.secondTopor.setBackgroundColor(Color.GREEN)
                3 -> binding.thirdTopor.setBackgroundColor(Color.GREEN)
            }
        }
    }
    private fun resetButtonColors(binding: ActivityMainBinding) {
        binding.firstTopor.setBackgroundColor(Color.argb(0,0,0,0))
        binding.secondTopor.setBackgroundColor(Color.argb(0,0,0,0))
        binding.thirdTopor.setBackgroundColor(Color.argb(0,0,0,0))
    }
    private fun allColorsRed(binding: ActivityMainBinding){
        binding.firstTopor.setBackgroundColor(Color.RED)
        binding.secondTopor.setBackgroundColor(Color.RED)
        binding.thirdTopor.setBackgroundColor(Color.RED)
    }
}