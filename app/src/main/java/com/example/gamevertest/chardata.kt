package com.example.gamevertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class chardata : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chardata)

        var currentlv: Int = intent.getIntExtra("lv", 0)
        val btntogame = findViewById<Button>(R.id.button)
        val startgame = Intent(this, GameTest::class.java)

        btntogame.setOnClickListener {
            startgame.putExtra("lv",currentlv)
            startActivity(startgame)
        }

    }
}