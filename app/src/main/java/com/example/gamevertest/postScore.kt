package com.example.gamevertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.gamevertest.databinding.ActivityPostScoreBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class postScore : AppCompatActivity() {

    private lateinit var enterName: EditText
    private lateinit var enterLevel: EditText
    private lateinit var saveScore: Button
    private lateinit var dbRef: DatabaseReference
    private lateinit var binding: ActivityPostScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_score)

        enterName = findViewById(R.id.editTextName)
        enterLevel = findViewById(R.id.editTextNumber)
        saveScore = findViewById(R.id.saveData)

        //取得Firebase realtime database
        dbRef = FirebaseDatabase.getInstance().getReference("Level")

        saveScore.setOnClickListener{
            saveScoreData()
        }
    }

    private fun saveScoreData(){

        //取得暱稱和分數
        val playerName = enterName.text.toString()
        val playerLevel = enterLevel.text.toString()

        if (playerName.isEmpty()){
            enterName.error = "請輸入暱稱"
        }

        if (playerLevel.isEmpty()){
            enterLevel.error = "請輸入等級"
        }

        //抓取玩家暱稱和等級
        val player = PlayerModel(playerName, playerLevel)

        //顯示分數是否輸入成功
        dbRef.child(playerName).setValue(player).addOnCompleteListener{
            Toast.makeText(this,"等級輸入成功", Toast.LENGTH_LONG).show()
        }.addOnFailureListener{
            Toast.makeText(this,"等級輸入失敗", Toast.LENGTH_LONG).show()
        }
    }
}