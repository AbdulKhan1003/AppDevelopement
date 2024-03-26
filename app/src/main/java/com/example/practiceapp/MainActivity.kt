package com.example.practiceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.practiceapp.databinding.TicTacToeBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val comp:Button=findViewById(R.id.comp)
        val player2:Button=findViewById(R.id.player2)

        player2.setOnClickListener{
            val intent = Intent(this@MainActivity, TicTacToe::class.java)
            startActivity(intent)
            finish()

        }
        comp.setOnClickListener{
            val intent = Intent(this@MainActivity, Comp::class.java)
            startActivity(intent)
            finish()

        }


    }
}