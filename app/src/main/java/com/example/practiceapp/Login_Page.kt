package com.example.practiceapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri

class Login_Page: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_view)
        val emailValue="abdulkhan103@gmail.com"
        val passwordValue="AbdulKhan123"

        val secondaryemailValue="abdulkhan10000@gmail.com"
        val secondarypasswordValue="abdulhadi"
        val checkbox:CheckBox=findViewById(R.id.check)

        val EnteredValue:EditText=findViewById(R.id.email)
        val Enteredpass:EditText=findViewById(R.id.password)
        val loginBtn:Button=findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener {
            if (!checkbox.isChecked) {
                Toast.makeText(applicationContext, "Agree to the Terms & Conditions first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (passwordValue == Enteredpass.text.toString() && emailValue == EnteredValue.text.toString() || secondarypasswordValue == Enteredpass.text.toString() && secondaryemailValue == EnteredValue.text.toString()) {
                Toast.makeText(applicationContext, "Correct Password", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Incorrect Email or Password", Toast.LENGTH_SHORT).show()
            }

        }
        val signup: TextView = findViewById(R.id.signup_text)
        signup.setOnClickListener {
            val uri: Uri = Uri.parse("https://www.youtube.com/@FacileSolutions")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }
    }
}