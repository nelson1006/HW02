package com.example.gamevertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.example.gamevertest.databinding.ActivityGetScoreBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class getScore : AppCompatActivity() {

    //初始化變數
    private lateinit var playerRecyclerView: RecyclerView
    private lateinit var playerList: ArrayList<PlayerModel>
    private lateinit var dbRef: DatabaseReference
    private lateinit var binding: ActivityGetScoreBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_score)

        val btntomain = findViewById<Button>(R.id.btntomain)
        val btntogame = findViewById<Button>(R.id.btntogame)
        val intentmain = Intent(this, MainActivity::class.java)

        btntomain.setOnClickListener {
            startActivity(intentmain)
        }

        btntogame.visibility = View.INVISIBLE

        auth = Firebase.auth
        binding = ActivityGetScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = Firebase.auth.currentUser
        val database = Firebase.database("https://gamevertest-default-rtdb.firebaseio.com/")

        //playerRecyclerView = findViewById(R.id.showplayer)
        //playerRecyclerView.setHasFixedSize(true)
        //playerList = arrayListOf<PlayerModel>()

        binding.readdataBtn.setOnClickListener {

            val playerName : String = binding.etplayername.text.toString()
            if  (playerName.isNotEmpty()){

                getPlayerScore(playerName)
                btntogame.visibility = View.VISIBLE

            }else{

                Toast.makeText(this,"PLease enter the Username",Toast.LENGTH_SHORT).show()

            }
        }

    }

    private fun getPlayerScore(playerName: String){

        //取得Firebase realtime database
        val dbRef = FirebaseDatabase.getInstance().getReference("Level")
        //lvRef = FirebaseDatabase.getInstance().getReference("Score")
        dbRef.child(playerName).get().addOnSuccessListener {

            if (it.exists()){

                val playername = it.child("playerName").value
                var playerlevel = it.child("playerLevel").value
                Toast.makeText(this,"Successfuly Read", Toast.LENGTH_SHORT).show()
                var playercurrentlevel = playerlevel.toString().toInt()
                binding.etplayername.text.clear()
                binding.tvPlayerName.text = playername.toString()
                binding.tvPlayerLevel.text = playerlevel.toString()
                val btntogame = findViewById<Button>(R.id.btntogame)
                val intent = Intent(this, GameTest::class.java)

                btntogame.setOnClickListener {
                    intent.putExtra("lv",playercurrentlevel)
                    startActivity(intent)
                }

            }else{

                Toast.makeText(this,"Player Doesn't Exist", Toast.LENGTH_SHORT).show()

            }

        }.addOnFailureListener{

            Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()

        }

    }
}