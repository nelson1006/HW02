package com.example.gamevertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

import com.google.firebase.auth.FirebaseUser
import com.example.gamevertest.databinding.ActivityLogInBinding

class LogIn : AppCompatActivity() {
    //初始化變數
    private lateinit var binding: ActivityLogInBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)


        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        val email = binding.enterEmail.text.toString()
        val password = binding.enterPassword.text.toString()


        //get email and password
        binding.login.setOnClickListener {

            if (email.isEmpty()) {
                showMessage("請輸入電子郵件")
            } else if (password.isEmpty()) {
                showMessage("請輸入密碼")
            } else {
                logIn()
            }
        }

    }
    private fun logIn() {

        //不知道為什麼get不到全域變數這邊再放一次
        val email = binding.enterEmail.text.toString()
        val password = binding.enterPassword.text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    //Log.d("signInWithEmail:success")
                    println("---------signInWithEmail:success-----------")
                    val user = auth.currentUser
                } else {
                    it.exception?.message?.let {  }
                    println("---------error---------------")
                    showMessage("登入失敗，帳號或密碼錯誤")
                }
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