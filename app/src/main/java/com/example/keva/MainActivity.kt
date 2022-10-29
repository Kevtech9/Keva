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

class MainActivity : AppCompatActivity() {
    private lateinit var input_email: EditText
    private lateinit var input_phone: EditText
    private lateinit var input_password:EditText
    private lateinit var btnSignuup: Button
    private lateinit var reddlogin:Button
    private var mAuth:FirebaseAuth?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        input_email=findViewById(R.id.inputemail)
        input_phone=findViewById(R.id.inputphone)
        input_password=findViewById(R.id.inputpassword)
        btnSignuup=findViewById(R.id.btnsignup)
        reddlogin=findViewById(R.id.redlogout)
        mAuth= FirebaseAuth.getInstance()


        reddlogin.setOnClickListener {
            var inntett=Intent(this, Login::class.java)
            startActivity(inntett)
        }

        btnSignuup.setOnClickListener {
            var email = input_email.text.toString().trim()
            var password = input_password.text.toString().trim()
            mAuth!!.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    task: Task<AuthResult> ->
                if(task.isSuccessful){
                    Toast.makeText(this, "signed up sucessfully", Toast.LENGTH_SHORT).show()
                    var intent=Intent(this, Login::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Failed to create account", Toast.LENGTH_SHORT).show()
                    Log.d("Error==>", task.exception.toString())
                }

              

            }
        }
    }
}