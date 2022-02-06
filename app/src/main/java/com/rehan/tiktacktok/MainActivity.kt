package com.rehan.tiktacktok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buselect(view: View) {
        val choise = view as Button
        var cellID = 0
        when (choise.id) {
            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9
        }
        play(cellID, choise)
    }

    var playernumber = 1

    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()

    fun play(cellID: Int, choise: Button) {

        if (playernumber == 1) {
            choise.text = "O"
            choise.setBackgroundResource(R.color.darkagreen)
            player1.add(cellID)
            playernumber = 2
        } else {
            choise.text = "X"
            choise.setBackgroundResource(R.color.blue)
            player2.add(cellID)
            playernumber = 1
        }

        choise.isEnabled = false

    }
}