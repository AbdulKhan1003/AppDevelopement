package com.example.practiceapp
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.practiceapp.databinding.TicTacToeBinding
class TicTacToe: AppCompatActivity() {
    private val entertainedComponents: MutableList<Int> = arrayListOf()
    var player = "X"

    lateinit var dataBinding: TicTacToeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this@TicTacToe, R.layout.tic_tac_toe)
        var stop=true
        var counterx=0
        var counterO=0

        fun switch(): String {
            if (player == "X") {
                player = "O"
            } else {
                player = "X"
            }
            return player
        }
        fun checkWin(): Boolean {
            if (dataBinding.box1Child.text == dataBinding.box2Child.text && dataBinding.box2Child.text == dataBinding.box3Child.text && dataBinding.box1Child.text.isNotEmpty()) {
                dataBinding.linebox1.visibility=View.VISIBLE
                dataBinding.linebox2.visibility=View.VISIBLE
                dataBinding.linebox3.visibility=View.VISIBLE
                return true }
            else if (dataBinding.box4Child.text == dataBinding.box5Child.text && dataBinding.box5Child.text == dataBinding.box6Child.text && dataBinding.box4Child.text.isNotEmpty()) {
                dataBinding.linebox4.visibility=View.VISIBLE
                dataBinding.linebox5.visibility=View.VISIBLE
                dataBinding.linebox6.visibility=View.VISIBLE
                return true}
            else if (dataBinding.box7Child.text == dataBinding.box8Child.text && dataBinding.box8Child.text == dataBinding.box9Child.text && dataBinding.box7Child.text.isNotEmpty()) {
                dataBinding.linebox7.visibility=View.VISIBLE
                dataBinding.linebox8.visibility=View.VISIBLE
                dataBinding.linebox9.visibility=View.VISIBLE
                return true}
            else if (dataBinding.box1Child.text == dataBinding.box4Child.text && dataBinding.box4Child.text == dataBinding.box7Child.text && dataBinding.box1Child.text.isNotEmpty()) {
                dataBinding.linebox1.visibility=View.VISIBLE
                dataBinding.linebox4.visibility=View.VISIBLE
                dataBinding.linebox7.visibility=View.VISIBLE
                return true}
            else if (dataBinding.box2Child.text == dataBinding.box5Child.text && dataBinding.box5Child.text == dataBinding.box8Child.text && dataBinding.box2Child.text.isNotEmpty()) {
                dataBinding.linebox2.visibility=View.VISIBLE
                dataBinding.linebox5.visibility=View.VISIBLE
                dataBinding.linebox8.visibility=View.VISIBLE
                return true}
            else if (dataBinding.box3Child.text == dataBinding.box6Child.text && dataBinding.box6Child.text == dataBinding.box9Child.text && dataBinding.box3Child.text.isNotEmpty()) {
                dataBinding.linebox3.visibility=View.VISIBLE
                dataBinding.linebox6.visibility=View.VISIBLE
                dataBinding.linebox9.visibility=View.VISIBLE
                return true}
            else if (dataBinding.box1Child.text == dataBinding.box5Child.text && dataBinding.box5Child.text == dataBinding.box9Child.text && dataBinding.box1Child.text.isNotEmpty()) {
                dataBinding.linebox1.visibility=View.VISIBLE
                dataBinding.linebox5.visibility=View.VISIBLE
                dataBinding.linebox9.visibility=View.VISIBLE
                return true}
            else if (dataBinding.box3Child.text == dataBinding.box5Child.text && dataBinding.box5Child.text == dataBinding.box7Child.text && dataBinding.box3Child.text.isNotEmpty()) {
                dataBinding.linebox7.visibility=View.VISIBLE
                dataBinding.linebox5.visibility=View.VISIBLE
                dataBinding.linebox3.visibility=View.VISIBLE
                return true}
            return false
        }

        val boxes = listOf(dataBinding.box1Child, dataBinding.box2Child, dataBinding.box3Child, dataBinding.box4Child, dataBinding.box5Child, dataBinding.box6Child, dataBinding.box7Child, dataBinding.box8Child, dataBinding.box9Child)
        for (box in boxes) {
            box.setOnClickListener {
                if (!entertainedComponents.contains(box.id) && stop) {
                    box.text = player
                    entertainedComponents.add(box.id)
                    switch()
                    dataBinding.playerid.text="Player-$player turn"
                    if (checkWin()) {
                        Toast.makeText(applicationContext, "Game has ended", Toast.LENGTH_SHORT).show()
                        stop=false
                        switch()
                        if(player=="X"){
                            counterx=counterx+1
                            dataBinding.xCount.text="X Wins: $counterx"
                        }else{
                            counterO=counterO+1
                            dataBinding.yCount.text="O Wins: $counterO"
                        }

                        dataBinding.result.text = "$player won"
                        dataBinding.playerid.text="Game Ended"
                    }
                    else if(entertainedComponents.size>=9 && !checkWin()){
                        dataBinding.result.text="It's a Draw"
                        dataBinding.playerid.text="Game Ended"
                    }
                }
                else {
                    Toast.makeText(applicationContext, "Box already selected", Toast.LENGTH_SHORT).show()
                }
            }
        }
        dataBinding.resetBtn.setOnClickListener {
            entertainedComponents.clear()
            stop = true
            for (box in boxes) {
                box.text = ""
                dataBinding.linebox1.visibility=View.INVISIBLE
                dataBinding.linebox2.visibility=View.INVISIBLE
                dataBinding.linebox3.visibility=View.INVISIBLE
                dataBinding.linebox4.visibility=View.INVISIBLE
                dataBinding.linebox5.visibility=View.INVISIBLE
                dataBinding.linebox6.visibility=View.INVISIBLE
                dataBinding.linebox7.visibility=View.INVISIBLE
                dataBinding.linebox8.visibility=View.INVISIBLE
                dataBinding.linebox9.visibility=View.INVISIBLE
            }
            player = "X"
            dataBinding.playerid.text="Player-$player turn"

        }

        dataBinding.BackBtn.setOnClickListener {
            val intent = Intent(this@TicTacToe, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }}

