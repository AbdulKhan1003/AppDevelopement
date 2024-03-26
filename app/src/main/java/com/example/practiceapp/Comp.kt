package com.example.practiceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.practiceapp.databinding.TicTacToeBinding

class Comp : AppCompatActivity() {
    private val entertainedComponents: MutableList<Int> = arrayListOf()
    private var stop = false
    private var compwin = false
    private var playerwin = false
    private var counterx = 0
    private var counterO = 0
    private lateinit var dataBinding: TicTacToeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this@Comp, R.layout.tic_tac_toe)
        val boxes = listOf(dataBinding.box1Child, dataBinding.box2Child, dataBinding.box3Child, dataBinding.box4Child, dataBinding.box5Child, dataBinding.box6Child, dataBinding.box7Child, dataBinding.box8Child, dataBinding.box9Child)
        fun OTurn() {
            println("Executing OTurn()")
            boxes.filter { !entertainedComponents.contains(it.id) }
                if (dataBinding.box1Child.text == "O" && dataBinding.box2Child.text == "O") {
                    dataBinding.box3Child.text = "O"
                    entertainedComponents.add(dataBinding.box3Child.id)
                } else if (dataBinding.box5Child.text == "O" && dataBinding.box4Child.text == "O") {
                    dataBinding.box6Child.text = "O"
                    entertainedComponents.add(dataBinding.box3Child.id)
                } else if (dataBinding.box7Child.text == "O" && dataBinding.box8Child.text == "O") {
                    dataBinding.box9Child.text = "O"
                    entertainedComponents.add(dataBinding.box3Child.id)
                } else if (dataBinding.box1Child.text == "O" && dataBinding.box4Child.text == "O") {
                    dataBinding.box7Child.text = "O"
                    entertainedComponents.add(dataBinding.box3Child.id)
                } else if (dataBinding.box2Child.text == "O" && dataBinding.box5Child.text == "O") {
                    dataBinding.box8Child.text = "O"
                    entertainedComponents.add(dataBinding.box3Child.id)
                } else if (dataBinding.box3Child.text == "O" && dataBinding.box6Child.text == "O") {
                    dataBinding.box9Child.text = "O"
                    entertainedComponents.add(dataBinding.box3Child.id)
                } else if (dataBinding.box1Child.text == "O" && dataBinding.box5Child.text == "O") {
                    dataBinding.box9Child.text = "O"
                    entertainedComponents.add(dataBinding.box3Child.id)
                } else if (dataBinding.box3Child.text == "O" && dataBinding.box7Child.text == "O") {
                    dataBinding.box7Child.text = "O"
                    entertainedComponents.add(dataBinding.box3Child.id)
                } else if (dataBinding.box1Child.text == "X" && dataBinding.box2Child.text == "X" && dataBinding.box3Child.text.isEmpty()) {
                    dataBinding.box3Child.text = "O"
                    entertainedComponents.add(dataBinding.box3Child.id)
                } else if (dataBinding.box4Child.text == "X" && dataBinding.box5Child.text == "X" && dataBinding.box6Child.text.isEmpty()) {
                    dataBinding.box6Child.text = "O"
                    entertainedComponents.add(dataBinding.box6Child.id)
                } else if (dataBinding.box7Child.text == "X" && dataBinding.box8Child.text == "X" && dataBinding.box9Child.text.isEmpty()) {
                    dataBinding.box9Child.text = "O"
                    entertainedComponents.add(dataBinding.box9Child.id)
                } else if (dataBinding.box1Child.text == "X" && dataBinding.box4Child.text == "X" && dataBinding.box7Child.text.isEmpty()) {
                    dataBinding.box7Child.text = "O"
                    entertainedComponents.add(dataBinding.box7Child.id)
                } else if (dataBinding.box2Child.text == "X" && dataBinding.box5Child.text == "X" && dataBinding.box8Child.text.isEmpty()) {
                    dataBinding.box8Child.text = "O"
                    entertainedComponents.add(dataBinding.box8Child.id)
                } else if (dataBinding.box3Child.text == "X" && dataBinding.box6Child.text == "X" && dataBinding.box9Child.text.isEmpty()) {
                    dataBinding.box9Child.text = "O"
                    entertainedComponents.add(dataBinding.box9Child.id)
                } else if (dataBinding.box1Child.text == "X" && dataBinding.box5Child.text == "X" && dataBinding.box9Child.text.isEmpty()) {
                    dataBinding.box9Child.text = "O"
                    entertainedComponents.add(dataBinding.box9Child.id)
                } else if (dataBinding.box3Child.text == "X" && dataBinding.box5Child.text == "X" && dataBinding.box7Child.text.isEmpty()) {
                    dataBinding.box7Child.text = "O"
                    entertainedComponents.add(dataBinding.box7Child.id)
                } else {
                    val uncheckedBoxes = boxes.filter { !entertainedComponents.contains(it.id) }
                    val randomBox = uncheckedBoxes.random()
                    randomBox.text = "O"
                    entertainedComponents.add(randomBox.id)
                }
        }

        fun checkWin(): Boolean {
            if (dataBinding.box1Child.text == dataBinding.box2Child.text && dataBinding.box2Child.text == dataBinding.box3Child.text && dataBinding.box1Child.text.isNotEmpty()) {
                dataBinding.linebox1.visibility = View.VISIBLE
                dataBinding.linebox2.visibility = View.VISIBLE
                dataBinding.linebox3.visibility = View.VISIBLE
                if (dataBinding.box1Child.text == "O" && dataBinding.box2Child.text == "O" && dataBinding.box3Child.text == "O") {
                    compwin = true
                    playerwin = false
                }
                if (dataBinding.box1Child.text == "X" && dataBinding.box2Child.text == "X" && dataBinding.box3Child.text == "X") {
                    playerwin = true
                    compwin = false
                }
                return true
            } else if (dataBinding.box4Child.text == dataBinding.box5Child.text && dataBinding.box5Child.text == dataBinding.box6Child.text && dataBinding.box4Child.text.isNotEmpty()) {
                dataBinding.linebox4.visibility = View.VISIBLE
                dataBinding.linebox5.visibility = View.VISIBLE
                dataBinding.linebox6.visibility = View.VISIBLE
                if (dataBinding.box4Child.text == "O" && dataBinding.box5Child.text == "O" && dataBinding.box6Child.text == "O") {
                    compwin = true
                    playerwin = false
                }
                if (dataBinding.box4Child.text == "X" && dataBinding.box5Child.text == "X" && dataBinding.box6Child.text == "X") {
                    playerwin = true
                    compwin = false
                }
                return true
            } else if (dataBinding.box7Child.text == dataBinding.box8Child.text && dataBinding.box8Child.text == dataBinding.box9Child.text && dataBinding.box7Child.text.isNotEmpty()) {
                dataBinding.linebox7.visibility = View.VISIBLE
                dataBinding.linebox8.visibility = View.VISIBLE
                dataBinding.linebox9.visibility = View.VISIBLE
                if (dataBinding.box7Child.text == "O" && dataBinding.box8Child.text == "O" && dataBinding.box9Child.text == "O") {
                    compwin = true
                    playerwin = false
                }
                if (dataBinding.box7Child.text == "X" && dataBinding.box8Child.text == "X" && dataBinding.box9Child.text == "X") {
                    playerwin = true
                    compwin = false
                }
                return true
            } else if (dataBinding.box1Child.text == dataBinding.box4Child.text && dataBinding.box4Child.text == dataBinding.box7Child.text && dataBinding.box1Child.text.isNotEmpty()) {
                dataBinding.linebox1.visibility = View.VISIBLE
                dataBinding.linebox4.visibility = View.VISIBLE
                dataBinding.linebox7.visibility = View.VISIBLE
                if (dataBinding.box1Child.text == "O" && dataBinding.box4Child.text == "O" && dataBinding.box7Child.text == "O") {
                    compwin = true
                    playerwin = false
                }
                if (dataBinding.box1Child.text == "X" && dataBinding.box4Child.text == "X" && dataBinding.box7Child.text == "X") {
                    playerwin = true
                    compwin = false
                }
                return true
            } else if (dataBinding.box2Child.text == dataBinding.box5Child.text && dataBinding.box5Child.text == dataBinding.box8Child.text && dataBinding.box2Child.text.isNotEmpty()) {
                dataBinding.linebox2.visibility = View.VISIBLE
                dataBinding.linebox5.visibility = View.VISIBLE
                dataBinding.linebox8.visibility = View.VISIBLE
                if (dataBinding.box2Child.text == "O" && dataBinding.box5Child.text == "O" && dataBinding.box8Child.text == "O") {
                    compwin = true
                    playerwin = false
                }
                if (dataBinding.box2Child.text == "X" && dataBinding.box5Child.text == "X" && dataBinding.box8Child.text == "X") {
                    playerwin = true
                    compwin = false
                }
                return true
            } else if (dataBinding.box3Child.text == dataBinding.box6Child.text && dataBinding.box6Child.text == dataBinding.box9Child.text && dataBinding.box3Child.text.isNotEmpty()) {
                dataBinding.linebox3.visibility = View.VISIBLE
                dataBinding.linebox6.visibility = View.VISIBLE
                dataBinding.linebox9.visibility = View.VISIBLE
                if (dataBinding.box3Child.text == "O" && dataBinding.box6Child.text == "O" && dataBinding.box9Child.text == "O") {
                    compwin = true
                    playerwin = false
                }
                if (dataBinding.box3Child.text == "X" && dataBinding.box6Child.text == "X" && dataBinding.box9Child.text == "X") {
                    playerwin = true
                    compwin = false
                }
                return true
            } else if (dataBinding.box1Child.text == dataBinding.box5Child.text && dataBinding.box5Child.text == dataBinding.box9Child.text && dataBinding.box1Child.text.isNotEmpty()) {
                dataBinding.linebox1.visibility = View.VISIBLE
                dataBinding.linebox5.visibility = View.VISIBLE
                dataBinding.linebox9.visibility = View.VISIBLE
                if (dataBinding.box1Child.text == "O" && dataBinding.box5Child.text == "O" && dataBinding.box9Child.text == "O") {
                    compwin = true
                    playerwin = false
                }
                if (dataBinding.box1Child.text == "X" && dataBinding.box5Child.text == "X" && dataBinding.box9Child.text == "X") {
                    playerwin = true
                    compwin = false
                }
                return true
            } else if (dataBinding.box3Child.text == dataBinding.box5Child.text && dataBinding.box5Child.text == dataBinding.box7Child.text && dataBinding.box3Child.text.isNotEmpty()) {
                dataBinding.linebox7.visibility = View.VISIBLE
                dataBinding.linebox5.visibility = View.VISIBLE
                dataBinding.linebox3.visibility = View.VISIBLE
                if (dataBinding.box3Child.text == "O" && dataBinding.box5Child.text == "O" && dataBinding.box7Child.text == "O") {
                    compwin = true
                    playerwin = false
                }
                if (dataBinding.box3Child.text == "X" && dataBinding.box5Child.text == "X" && dataBinding.box7Child.text == "X") {
                    playerwin = true
                    compwin = false
                }
                return true
            }
            return false
        }

        fun Xturns() {
            println("Executing XTurn()")
            for (box in boxes) {
                box.setOnClickListener {
                    if (!entertainedComponents.contains(box.id) && !stop) {
                        box.text = "X"
                        entertainedComponents.add(box.id)
                        dataBinding.playerid.text = "Player-X turn"
                        if(!checkWin()){
                            OTurn()
                        }
                        if (checkWin()) {
                            Toast.makeText(applicationContext, "Game has ended", Toast.LENGTH_SHORT)
                                .show()
                            stop = true
                            if (playerwin && !compwin) {
                                counterx++
                                dataBinding.xCount.text = "X Wins: $counterx"
                                dataBinding.result.text = "X won"
                                dataBinding.playerid.text = "Game Ended"
                            }
                            if (compwin) {
                                dataBinding.result.text = "O won"
                                dataBinding.playerid.text = "Game Ended"
                                counterO++
                                dataBinding.yCount.text = "O Wins: $counterO"
                            }
                        } else if (entertainedComponents.size == 9 && !checkWin()) {
                            dataBinding.result.text = "It's a Draw"
                            dataBinding.playerid.text = "Game Ended"
                        }
                    } else {
                        Toast.makeText(applicationContext, "Box already selected", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
//        Everything working bcz of this
        Xturns()

        dataBinding.resetBtn.setOnClickListener {
            entertainedComponents.clear()
            stop = false
            compwin = false
            playerwin = false

            for (box in boxes) {
                box.text = ""
                dataBinding.linebox1.visibility = View.INVISIBLE
                dataBinding.linebox2.visibility = View.INVISIBLE
                dataBinding.linebox3.visibility = View.INVISIBLE
                dataBinding.linebox4.visibility = View.INVISIBLE
                dataBinding.linebox5.visibility = View.INVISIBLE
                dataBinding.linebox6.visibility = View.INVISIBLE
                dataBinding.linebox7.visibility = View.INVISIBLE
                dataBinding.linebox8.visibility = View.INVISIBLE
                dataBinding.linebox9.visibility = View.INVISIBLE
            }
            Xturns()
        }

        dataBinding.BackBtn.setOnClickListener {
            val intent = Intent(this@Comp, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    }