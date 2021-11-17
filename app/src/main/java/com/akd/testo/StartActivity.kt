package com.akd.testo

import android.app.Application
import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

private lateinit var next:Button

class StartActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        supportActionBar?.hide()
        next = findViewById(R.id.startApp)
        next.setOnClickListener{
            val toMain = Intent(this, MainActivity::class.java)
            startActivity(toMain)
            finish()
        }
    }
}