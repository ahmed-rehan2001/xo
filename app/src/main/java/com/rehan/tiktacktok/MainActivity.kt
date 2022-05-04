package com.rehan.tiktacktok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

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
            //CheckWinner()
            Autoplay()
        } else {
            choise.text = "X"
            choise.setBackgroundResource(R.color.blue)
            player2.add(cellID)
            playernumber = 1
            //CheckWinner()
        }

        choise.isEnabled = false
        CheckWinner()
    }

    fun CheckWinner(){
        var winner=-1
        //row 1
        if(player1.contains (1) && player1.contains(2) && player1.contains (3) ){
            winner=1}
        if(player2.contains(1) && player2.contains (2) && player2.contains(3) ) {
            winner=2 }
        //row 2
        if(player1.contains (4) && player1.contains (5) && player1.contains (6) ){
            winner=1}
        if(player2.contains (4) && player2.contains (5) && player2.contains (6) ){
            winner=2 }
        //row 3
        if(player1.contains (7) && player1.contains (8) && player1.contains (9) ){
            winner=1}
        if(player2.contains (7) && player2.contains (8) && player2.contains (9) ){
            winner=2 }
        //col 1
        if(player1.contains (1) && player1.contains (4) && player1.contains (7) ){
            winner=1}
        if(player2.contains (1) && player2.contains (4) && player2.contains (7) ){
            winner=2 }
        //col 2
        if(player1.contains (2) && player1.contains (5) && player1.contains (8) ){
            winner=1}
        if(player2.contains (2) && player2.contains (5) && player2.contains (8) ){
            winner=2 }
        //col 3
        if(player1.contains (3) && player1.contains (6) && player1.contains (9) ){
            winner=1}
        if(player2.contains (3) && player2.contains (6) && player2.contains (9) ){
            winner=2 }
        //sam 1
        if(player1.contains (1) && player1.contains (5) && player1.contains (9) ){
            winner=1}
        if(player2.contains (1) && player2.contains (5) && player2.contains (9) ){
            winner=2 }
        //sam 2
        if(player1.contains (3) && player1.contains (5) && player1.contains (7) ){
            winner=1}
        if(player2.contains (3) && player2.contains (5) && player2.contains (7) ){
            winner=2 }

        if (winner!=-1){
            if (winner==1){
             Toast.makeText(this, "player O win the game", Toast.LENGTH_LONG).show()}

            if (winner==2){
             Toast.makeText(this, "player X win the game", Toast.LENGTH_LONG).show()}

        }
    }

    fun Autoplay() {
     val emptycells=ArrayList<Int>()
        for (i in 1..9)
        { if( !player1.contains(i) || !player2.contains(i)){
            emptycells.add(i);
        } }
        val ran= (1..emptycells.size).random() //get any random number between 0 to 9
        val cellID=emptycells[ran]
        var buselect :Button?
        when(cellID)
        {
            1->buselect=bu1
            2->buselect=bu2
            3->buselect=bu3
            4->buselect=bu4
            5->buselect=bu5
            6->buselect=bu6
            7->buselect=bu7
            8->buselect=bu8
            9->buselect=bu9
            else->{buselect=bu1}

        }
        play(cellID,buselect)

    }

}