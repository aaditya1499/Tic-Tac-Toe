package tictac.aaditya.com.tictactoenew

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeActivity(view: View) {

        val bselected:Button=view as Button
        when(bselected.id){
            R.id.sp -> {
                val intent1=Intent(this,SinglePlayer::class.java)
                this.startActivity(intent1)
            }
            else -> {
                val intent=Intent(this,TwoPlayer::class.java)
                this.startActivity(intent)
            }
        }

    }
}



