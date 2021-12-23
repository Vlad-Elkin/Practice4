package com.example.lengthunitstranslator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.animation.AlphaAnimation
import android.widget.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val km=findViewById<EditText>(R.id.km)
        val m =findViewById<EditText>(R.id.m)
        val dm=findViewById<EditText>(R.id.dm)
        val sm=findViewById<EditText>(R.id.sm)
        val mm=findViewById<EditText>(R.id.mm)
        val result=findViewById<TextView>(R.id.rezult)
        val image = findViewById<ImageView>(R.id.answer)
        val b =findViewById<Button>(R.id.inspect)
        b.setOnClickListener {
            if(km.text.toString()!="" && m.text.toString()!="" && dm.text.toString()!="" && sm.text.toString()!="" && mm.text.toString()!="") {
                if (m.text.toString().toDouble()/km.text.toString().toDouble()==1000.0 &&
                    dm.text.toString().toDouble()/km.text.toString().toDouble()==10000.0 &&
                    sm.text.toString().toDouble()/km.text.toString().toDouble()==100000.0 &&
                    mm.text.toString().toDouble()/km.text.toString().toDouble()==1000000.0)
                    {
                        result.text = getString(R.string.good);
                        image.setImageResource(R.drawable.good);
                        image.setOnTouchListener{view, motionEvent ->
                        when(motionEvent.action) {
                            MotionEvent.ACTION_DOWN -> {image.imageAlpha-=0x14}
                        }
                        true
                        }

                }
                else{
                    result.text = getString(R.string.bad);
                    image.setImageResource(R.drawable.bad);
                    image.setOnTouchListener{view, motionEvent ->
                        when(motionEvent.action) {
                            MotionEvent.ACTION_DOWN -> {image.imageAlpha-=0x14}
                        }
                        true
                    }
                }
            }
        }
    }
}