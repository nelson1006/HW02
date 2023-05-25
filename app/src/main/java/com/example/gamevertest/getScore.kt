package com.example.gamevertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class getScore : AppCompatActivity() {

    //初始化變數
    private lateinit var playerRecyclerView: RecyclerView
    private lateinit var playerList: ArrayList<PlayerModel>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_score)

        playerRecyclerView = findViewById(R.id.showplayer)
        playerRecyclerView.setHasFixedSize(true)
        playerList = arrayListOf<PlayerModel>()
        getPlayerScore()



    }

    private fun getPlayerScore(){

        //取得Firebase realtime database
        dbRef = FirebaseDatabase.getInstance().getReference("score")
        dbRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                playerList.clear()
                if (snapshot.exists()){
                    for (playerSnap in snapshot.children){
                        val playerScore = playerSnap.getValue(PlayerModel::class.java)
                        playerList.add(playerScore!!)
                    }
                    val mAdapter = PlayerAdapter(playerList)
                    playerRecyclerView.adapter = mAdapter

                    playerRecyclerView.visibility = View.VISIBLE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}