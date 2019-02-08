package tictac.aaditya.com.tictactoenew

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_replay.*

class Replay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_replay)
        var bundle:Bundle=intent.extras
        var winn=bundle.getString("win","Draw")
        win.text=winn
    }

    fun replay (view:View){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
    }

    fun quit(view: View){
        finish()
        System.exit(0)
    }
}
