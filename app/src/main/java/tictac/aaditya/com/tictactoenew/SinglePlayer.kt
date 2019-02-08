package tictac.aaditya.com.tictactoenew

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_single_player.*
import java.util.*

class SinglePlayer : AppCompatActivity() {
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var win:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_player)
    }

    fun click(view: View) {

        val bselected: Button = view as Button
        var cellId = 0
        when (bselected.id) {
            R.id.b1 -> cellId = 1
            R.id.b2 -> cellId = 2
            R.id.b3 -> cellId = 3
            R.id.b4 -> cellId = 4
            R.id.b5 -> cellId = 5
            R.id.b6 -> cellId = 6
            R.id.b7 -> cellId = 7
            R.id.b8 -> cellId = 8
            R.id.b9 -> cellId = 9

        }
        play(cellId, bselected)

    }


    var activePlayer = 1
    fun play(cellId: Int, bselected: Button) {
        if (activePlayer == 1) {
            bselected.text = "X"
            bselected.setTextColor(resources.getColor(R.color.white))
            bselected.setBackgroundResource(R.color.darkgreen)
            bselected.isEnabled=false
            player1.add(cellId)
            activePlayer = 2
            bselected.isEnabled = false
            autoPlay()

        }
        else {
            bselected.text = "O"
            bselected.setTextColor(resources.getColor(R.color.white))
            bselected.setBackgroundResource(R.color.red)
            player2.add(cellId)
            activePlayer = 1
            bselected.isEnabled = false
        }
        bselected.isEnabled = false
        winner()
    }

    fun winner() {
        var msg = ""
        var end: Boolean = false
        var winner = -1
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        //col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        //col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }
        //diag R
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        //diag L
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }
        if (winner == 1) {

            //Toast.makeText(applicationContext,"Winner is Player 1",Toast.LENGTH_LONG).show()
            win=1
            val intent= Intent(applicationContext,Replay::class.java)
            intent.putExtra("win","Winner is player 1")
            startActivity(intent)

        }
        if (winner == 2) {
            //Toast.makeText(applicationContext,"Winner is Player 2",Toast.LENGTH_LONG).show()
            win=2
            val intent= Intent(applicationContext,Replay::class.java)
            intent.putExtra("win","Winner is player 2")
            startActivity(intent)
        }
    }

    fun autoPlay() {
        var emptyCell = ArrayList<Int>()
        for (cellId in 1..9) {
            if (!(player1.contains(cellId) || player2.contains(cellId))) {
                emptyCell.add(cellId)
            }
        }
        if(emptyCell.size==0){
                val intent= Intent(applicationContext,Replay::class.java)
                intent.putExtra("win","The game is draw")
                this.startActivity(intent)
        }
        if (emptyCell.size > 0) {
            val r = Random()
            val randomIndex = r.nextInt(emptyCell.size - 0) + 0
            val cellId = emptyCell[randomIndex!!]
            var bselected: Button?
            when (cellId) {
                1 -> bselected = b1
                2 -> bselected = b2
                3 -> bselected = b3
                4 -> bselected = b4
                5 -> bselected = b5
                6 -> bselected = b6
                7 -> bselected = b7
                8 -> bselected = b8
                9 -> bselected = b9

                else -> {
                    bselected = b1
                }
            }

            play(cellId, bselected)

        }

    }

}
