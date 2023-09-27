package com.pmm.myapplicationlogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var imageViewUser: ImageView
    private lateinit var textViewUsername: TextView
    private lateinit var buttonYes: Button
    private lateinit var buttonNo: Button
    private lateinit var buttonBackToLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val username = intent.getStringExtra("username")
        val imageView = findViewById<ImageView>(R.id.imageViewUser)
        val usernameTextView = findViewById<TextView>(R.id.textViewUsername)
        val backButton = findViewById<Button>(R.id.buttonBackToLogin)
        val yesButton = findViewById<Button>(R.id.buttonYes)
        val noButton = findViewById<Button>(R.id.buttonNo)

        // Tampilkan username yang masuk
        usernameTextView.text = "Selamat Datang, $username!"

        // Asumsikan bahwa Anda memiliki gambar profil dengan nama yang sesuai dengan username
        val imageResource = resources.getIdentifier(username, "drawable", packageName)

        if (imageResource != 0) {
            imageView.setImageResource(imageResource)
        } else {
            // Jika gambar profil tidak ditemukan, Anda dapat menampilkan gambar default atau tindakan lain.
            // imageView.setImageResource(R.drawable.default_profile)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        yesButton.setOnClickListener {
            // Lakukan tindakan jika user mengonfirmasi bahwa itu benar dia
        }

        noButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
