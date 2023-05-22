package com.example.gamevertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

import com.google.firebase.auth.FirebaseUser
import com.example.gamevertest.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    //初始化變數
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        //取得email and password
        binding.signup.setOnClickListener {

            val email = binding.enterEmail2.text.toString()
            val password = binding.enterPassword2.text.toString()

            auth.createUserWithEmailAndPassword(email, password) //email和password放進函式
                .addOnCompleteListener {

                    if (email.isEmpty()){
                        Toast.makeText(this,"請輸入電子郵件", Toast.LENGTH_SHORT).show()
                    }

                    if (password.isEmpty()){
                        Toast.makeText(this,"請輸入密碼", Toast.LENGTH_SHORT).show()
                    }

                    //判斷傳值是否成功
                    if (it.isSuccessful) {
                        Log.d("註冊", "註冊成功")
                        finish()
                    }
                    //顯示註冊失敗
                    else{
                        Log.w("註冊","註冊失敗", it.exception)
                        showMessage("註冊失敗")
                    }

                }
        }


    }

    //註冊失敗副函式
    private fun showMessage(message: String) {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("確定") { dialog, which -> }
        alertDialog.show()
    }

}