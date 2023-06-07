package com.example.gamevertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class GameTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_test)

        var battleresult = 0
        val btnbattle = findViewById<Button>(R.id.btnbattle)
        val charhpview = findViewById<TextView>(R.id.charhpview)
        val monsterhpview = findViewById<TextView>(R.id.monsterhpview)

        var lv: Int = intent.getIntExtra("currentlv", 0)
        var basiccharhp : Int = 10
        var basiccharatk: Int = 2
        var basicmonsterhp: Int = 8
        var basicmonsteratk: Int = 2

        var charhp = lv*2+basiccharhp
        var charatk = lv*2+basiccharatk
        var monsterhp = lv*2+basicmonsterhp
        var monsteratk = lv*2+basicmonsteratk

        charhpview.text = charhp.toString()
        monsterhpview.text = monsterhp.toString()

        btnbattle.setOnClickListener {
            monsterhp = monsterhp - charatk
            charhp = charhp - monsteratk
            monsterhpview.text = monsterhp.toString()
            charhpview.text = charhp.toString()


            if (monsterhp <= 0 && charhp > 0) {
                btnbattle.visibility = View.INVISIBLE
                battleresult = 1
                Toast.makeText(this, "勝利", Toast.LENGTH_SHORT).show()
            }

            if (monsterhp > 0 && charhp <= 0) {
                btnbattle.visibility = View.INVISIBLE
                battleresult = 2
                Toast.makeText(this, "失敗", Toast.LENGTH_SHORT).show()
            }
        }


    }
}