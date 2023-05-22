package com.example.gamevertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class getScore : AppCompatActivity() {

    //初始化變數
    private lateinit var playerRecyclerView: RecyclerView
    private lateinit var showLoading: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_score)

        playerRecyclerView = findViewById(R.id.showplayer)
        showLoading = findViewById(R.id.showLoading)







    }
}