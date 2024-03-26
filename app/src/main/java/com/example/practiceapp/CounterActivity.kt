package com.example.practiceapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class CounterActivity: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.counter_view)

        val counter:Button=findViewById(R.id.counterbtn)
        val countertext:TextView=findViewById(R.id.countertext)
        countertext.text="0";
        counter.setOnClickListener {
            val countervalue = Integer.parseInt(countertext.text.toString())
        countertext.text=(countervalue+1).toString()
        }
        val displayname:EditText=findViewById(R.id.name)
        val displaybtn:Button=findViewById(R.id.counterdisplay)
        displaybtn.setOnClickListener {
            Toast.makeText(applicationContext, displayname.text.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}