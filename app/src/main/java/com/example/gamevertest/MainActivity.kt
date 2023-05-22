package com.example.gamevertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {

    private lateinit var insertData: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonlogin = findViewById<Button>(R.id.button_login)
        val buttonsignup = findViewById<Button>(R.id.button_signup)
        //val buttoninsert = findViewById<Button>(R.id.button_insert)
        val buttonget = findViewById<Button>(R.id.button_get)
        val LogIn = Intent(this, LogIn::class.java)
        val SignUp = Intent(this, SignUp::class.java)
        val insert = Intent(this, postScore::class.java)
        val get = Intent(this, getScore::class.java)

        buttonlogin.setOnClickListener {
            //startActivity(Intent(this, LogIn::class.java))
            startActivity(LogIn)
        }

        buttonsignup.setOnClickListener {
            //startActivity(Intent(this, SignUp::class.java))
            startActivity(SignUp)
        }

        val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()

        insertData = findViewById(R.id.button_insert)

        insertData.setOnClickListener{
            startActivity(insert)
        }


        buttonget.setOnClickListener {
            //startActivity(Intent(this, getScore::class.java))
            startActivity(get)
        }
    }
}
