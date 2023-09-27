package com.pmm.myapplicationlogin;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var textViewTitle: TextView
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonSubmit: Button
    private lateinit var buttonCancel: Button
    private lateinit var textViewResponse: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonSubmit.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            if (isValidUser(username, password)) {
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            } else {
                textViewResponse.text = "Username atau password salah."
            }
        }

        buttonCancel.setOnClickListener {
            editTextUsername.text.clear()
            editTextPassword.text.clear()
        }
    }

    private fun isValidUser(username: String, password: String): Boolean {
        // Cek apakah username dan password sesuai dengan daftar pengguna yang valid.
        val validUsers = listOf("user1", "user2", "user3", "user4", "user5")
        val validPasswords = listOf("pass1", "pass2", "pass3", "pass4", "pass5")

        return validUsers.contains(username) && validPasswords.contains(password)
    }
}
