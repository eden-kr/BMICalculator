package com.example.bimcalculator

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import  org.jetbrains.anko.*

//비만도 계산기
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("비만도 계산기")

        val intent = Intent(this,ResultActivity::class.java)


        resultButton.setOnClickListener {
            if(rdo.rdBoy.isChecked){
                var height = heightEditText.text.toString()
                var weight = weightEditText.text.toString()
                var age = ageEditText.text.toString()
                intent.putExtra("height",height)
                intent.putExtra("weight",weight)
                intent.putExtra("age",age)
                intent.putExtra("sex","man")
                startActivity(intent)
            }
            else if(rdo.rdGirl.isChecked){
                var height = heightEditText.text.toString()
                var weight = weightEditText.text.toString()
                var age = ageEditText.text.toString()
                intent.putExtra("height",height)
                intent.putExtra("weight",weight)
                intent.putExtra("age",age)
                intent.putExtra("sex","woman")
                startActivity(intent)

            }
        }
        btnReset.setOnClickListener {
            rdBoy.isChecked = false
            rdGirl.isChecked = false
            heightEditText.text.clear()
            weightEditText.text.clear()
            ageEditText.text.clear()
        }
    }
}

