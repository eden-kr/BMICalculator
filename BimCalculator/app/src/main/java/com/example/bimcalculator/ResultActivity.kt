package com.example.bimcalculator

import android.content.Context
import android.graphics.Color
import android.graphics.ColorMatrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.toast

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        setTitle("비만도 계산기")

        val height = intent.getStringExtra("height").toInt()
        val weight = intent.getStringExtra("weight").toInt()
        val age = intent.getStringExtra("age").toInt()
        val str = intent.extras?.getString("sex")
        val bmi = weight/Math.pow(height / 100.0, 2.0)
        val fatWoman = (1.07*weight)-(128*(weight)/(height))
        val fatMan = (1.1*weight) - (128*(weight)/(height))

        if(str.equals("woman")){
            when{
                bmi >= 40 -> {
                    resultTextView.text ="주의가 필요해요!"
                    ff.text = "고위험"
                    layout.setBackgroundColor(Color.RED)
                    //Drawble에서 디자인한 파일 적용
                    layout2.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.recbad))
                    bmiResult.text = (Math.round(bmi*100)/100.0).toString()
                    bmiState.text = "고도비만"
                    fatState.text = (Math.round(fatWoman*100)/100.0).toString()
                }
                bmi >= 30 -> {
                    resultTextView.text = "주의가 필요해요!"
                    ff.text = "위험"
                    layout.setBackgroundColor(Color.RED)
                    layout2.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.recbad))
                    bmiResult.text = (Math.round(bmi*100)/100.0).toString()
                    bmiState.text = "2도비만"
                    fatState.text = (Math.round(fatWoman*100)/100.0).toString()
                }
                bmi >= 25 -> {
                    resultTextView.text ="건강에 유의하세요!"
                    ff.text = "주의"
                    layout.setBackgroundColor(Color.rgb(255,87,34))
                    layout2.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.reccaoution))
                    bmiResult.text = (Math.round(bmi*100)/100.0).toString()
                    bmiState.text = "1도비만"
                    fatState.text = (Math.round(fatWoman*100)/100.0).toString()
                }
                bmi >= 20 -> {
                    resultTextView.text ="정상 체중입니다."
                    ff.text = "정상"
                    layout.setBackgroundColor(Color.rgb(0,188,212))
                    layout2.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.recavg))
                    bmiResult.text = (Math.round(bmi*100)/100.0).toString()
                    bmiState.text = "정상"
                    fatState.text = (Math.round(fatWoman*100)/100.0).toString()
                }
                else -> {
                    resultTextView.text = "건강에 유의하세요!"
                    ff.text = "주의"
                    layout.setBackgroundColor(Color.rgb(255,87,34))
                    layout2.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.reccaoution))
                    bmiResult.text = (Math.round(bmi*100)/100.0).toString()
                    bmiState.text = "저체중"
                    fatState.text = (Math.round(fatWoman*100)/100.0).toString()
                }
            }
            when{
                bmi >= 30 ->
                    imageView.setImageResource(
                        R.drawable.ic_sentiment_very_dissatisfied_black_24dp
                    )
                bmi >= 25 ->
                    imageView.setImageResource(
                        R.drawable.ic_sentiment_dissatisfied_black_24dp
                    )
                bmi >= 20 ->
                    imageView.setImageResource(
                        R.drawable.ic_sentiment_satisfied_black_24dp
                    )
                else ->
                    imageView.setImageResource(
                        R.drawable.ic_sentiment_dissatisfied_black_24dp
                    )
            }
        }
        else if(str.equals("man")){
            when{
                bmi >= 40 -> {
                    resultTextView.text ="주의가 필요해요!"
                    ff.text = "고위험"
                    layout.setBackgroundColor(Color.RED)
                    //Drawble에서 디자인한 파일 적용
                    layout2.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.recbad))
                    bmiResult.text = (Math.round(bmi*100)/100.0).toString()
                    bmiState.text = "고도비만"
                    fatState.text = (Math.round(fatMan*100)/100.0).toString()
                }
                bmi >= 30 -> {
                    resultTextView.text = "주의가 필요해요!"
                    ff.text = "위험"
                    layout.setBackgroundColor(Color.RED)
                    layout2.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.recbad))
                    bmiResult.text = (Math.round(bmi*100)/100.0).toString()
                    bmiState.text = "2도비만"
                    fatState.text = (Math.round(fatMan*100)/100.0).toString()
                }
                bmi >= 25 -> {
                    resultTextView.text ="건강에 유의하세요!"
                    ff.text = "주의"
                    layout.setBackgroundColor(Color.rgb(255,87,34))
                    layout2.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.reccaoution))
                    bmiResult.text = (Math.round(bmi*100)/100.0).toString()
                    bmiState.text = "1도비만"
                    fatState.text = (Math.round(fatMan*100)/100.0).toString()
                }
                bmi >= 20 -> {
                    resultTextView.text ="정상 체중입니다."
                    ff.text = "정상"
                    layout.setBackgroundColor(Color.rgb(0,188,212))
                    layout2.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.recavg))
                    bmiResult.text = (Math.round(bmi*100)/100.0).toString()
                    bmiState.text = "정상"
                    fatState.text = (Math.round(fatMan*100)/100.0).toString()
                }
                else -> {
                    resultTextView.text = "건강에 유의하세요!"
                    ff.text = "주의"
                    layout.setBackgroundColor(Color.rgb(255,87,34))
                    layout2.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.reccaoution))
                    bmiResult.text = (Math.round(bmi*100)/100.0).toString()
                    bmiState.text = "저체중"
                    fatState.text = (Math.round(fatMan*100)/100.0).toString()
                }
            }
            when{
                bmi >= 30 ->
                    imageView.setImageResource(
                        R.drawable.ic_sentiment_very_dissatisfied_black_24dp
                    )
                bmi >= 25 ->
                    imageView.setImageResource(
                        R.drawable.ic_sentiment_dissatisfied_black_24dp
                    )
                bmi >= 20 ->
                    imageView.setImageResource(
                        R.drawable.ic_sentiment_satisfied_black_24dp
                    )
                else ->
                    imageView.setImageResource(
                        R.drawable.ic_sentiment_dissatisfied_black_24dp
                    )
            }
        }
        /*
        toast("$bmi")*/
    }

}
