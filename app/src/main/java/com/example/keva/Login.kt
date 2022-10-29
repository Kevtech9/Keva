package com.example.keva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var input_email:EditText
    private lateinit var input_password:EditText
    private lateinit var btnloggin:Button
    private lateinit var btnredsignup:Button
private var mAuth:FirebaseAuth?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        input_email=findViewById(R.id.edtemail)
        input_password=findViewById(R.id.edtpassword)
        btnloggin=findViewById(R.id.btnlogin)
        btnredsignup=findViewById(R.id.btnredsignup)
        mAuth=FirebaseAuth.getInstance()

        btnredsignup.setOnClickListener {
            var inntet=Intent(this, MainActivity::class.java)
            startActivity(inntet)
        }

        btnloggin.setOnClickListener {
            var email=input_email.text.toString().trim()
            var password=input_password.text.toString().trim()
          mAuth!!.signInWithEmailAndPassword(email, password).addOnCompleteListener {
              task:Task<AuthResult> ->
              if (task.isSuccessful){
                  Toast.makeText(this, "Logged in sucessfully", Toast.LENGTH_SHORT).show()
                  var intent=Intent(this, Dashboard::class.java)
                  startActivity(intent)
          } else{
                  Toast.makeText(this, "Log in failed", Toast.LENGTH_SHORT).show()
              }

          }

        }
    }
}