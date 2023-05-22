package com.example.gamevertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog



class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

            val button_confirm = findViewById<Button>(R.id.signup)
            button_confirm.setOnClickListener {
            //startActivity(Intent(this,MainActivity2::class.java))


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
    //登入失敗的functuon
    private fun showMessage(message: String) {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("確定") { dialog, which -> }
        alertDialog.show()
    }
}