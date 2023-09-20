package com.example.appfiapreciclagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appfiapreciclagem.databinding.ActivityApoiadoresTelaBinding

class ApoiadoresTela : AppCompatActivity() {

    private lateinit var binding: ActivityApoiadoresTelaBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityApoiadoresTelaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.telaInicial3.setOnClickListener {
            val telainicial = Intent(this, MainActivity::class.java)
            startActivity(telainicial)
        }
        binding.blogTela3.setOnClickListener {
            val telaBlog = Intent(this, TelaBlog::class.java)
            startActivity(telaBlog)
        }
    }
}