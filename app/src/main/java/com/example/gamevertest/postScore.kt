package com.example.gamevertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class postScore : AppCompatActivity() {

    private lateinit var enterName: EditText
    private lateinit var enterScore: EditText

    private lateinit var saveScore: Button
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_score)

        enterName = findViewById(R.id.editTextName)
        enterScore = findViewById(R.id.editTextNumber)
        saveScore = findViewById(R.id.saveData)

        //取得Firebase realtime database
        dbRef = FirebaseDatabase.getInstance().getReference("Score")

        saveScore.setOnClickListener{
            saveScoreData()
        }

    }

    private fun saveScoreData(){

        //取得暱稱和分數
        val playername = enterName.text.toString()
        val playerscore = enterScore.text.toString()

        if (playername.isEmpty()){
            enterName.error = "請輸入暱稱"
        }

        if (playerscore.isEmpty()){
            enterScore.error = "請輸入分數"
        }


        //創建playerid唯一鍵
        val playerid = dbRef.push().key!!

        //抓取玩家暱稱和分數
        val player = PlayerModel(playername, playerscore)

        //顯示分數是否輸入成功
        dbRef.child(playerid).setValue(player).addOnCompleteListener{
            Toast.makeText(this,"分數輸入成功", Toast.LENGTH_LONG).show()
        }.addOnFailureListener{
            Toast.makeText(this,"分數輸入失敗", Toast.LENGTH_LONG).show()
        }
    }

}