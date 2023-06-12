package com.example.gamevertest

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class chardata : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chardata)

        var currentlv: Int = intent.getIntExtra("lv", 0)
        val btntogame = findViewById<Button>(R.id.button)
        val startgame = Intent(this, GameTest::class.java)
        val items = findViewById<ImageView>(R.id.imageViewitem1)

        btntogame.setOnClickListener {
            startgame.putExtra("lv",currentlv)
            startActivity(startgame)
        }

        items.setOnClickListener {
            startActivity(Intent(this,itemlist::class.java))
        }

    }
}