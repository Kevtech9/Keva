package com.example.keva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Dashboard : AppCompatActivity() {
    private lateinit var btnbtnlogout:Button
    private var mAuth:FirebaseAuth?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        btnbtnlogout=findViewById(R.id.btnlogout)
        mAuth= FirebaseAuth.getInstance()

        btnbtnlogout.setOnClickListener {
            mAuth!!.signOut()
            Toast.makeText(this, "User Logged Out", Toast.LENGTH_SHORT).show()
            val logoutintent=Intent(this, Login::class.java)
            startActivity(logoutintent)
            finish()
        }
    }
}