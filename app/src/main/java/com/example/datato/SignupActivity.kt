package com.example.datato

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    private lateinit var editName: EditText
    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var btnSignup: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        mAuth = FirebaseAuth.getInstance()

        editName = findViewById(R.id.edit_name)
        editEmail = findViewById(R.id.edit_email)
        editPassword = findViewById(R.id.edit_password)
        btnSignup = findViewById(R.id.btn_signUp)

        btnSignup.setOnClickListener {
            val email = editEmail.text.toString()
            val password = editPassword.text.toString()
            signUp(email,password)

        }
    }

    private fun signUp(email: String,password: String){
       // logic for signing user
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // code for jumping to home

                    val intent = Intent(this@SignupActivity, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this@SignupActivity, "some error occurred", Toast.LENGTH_SHORT).show()

                }
            }
    }
}