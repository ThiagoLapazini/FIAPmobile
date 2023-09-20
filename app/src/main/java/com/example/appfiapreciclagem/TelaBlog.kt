package com.example.appfiapreciclagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appfiapreciclagem.databinding.ActivityMainBinding
import com.example.appfiapreciclagem.databinding.ActivityTelalBlogBinding

class TelaBlog : AppCompatActivity() {

    private lateinit var binding: ActivityTelalBlogBinding
    override
    fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTelalBlogBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.telaInicial2.setOnClickListener {
            irParaTelaInicialTela()
        }
        binding.btApoiadores2.setOnClickListener{
            irParaApoiadores()
        }
    }
    private fun irParaApoiadores() {
        val apoiadores = Intent(this, ApoiadoresTela::class.java)
        startActivity(apoiadores)
    }
    private fun irParaTelaInicialTela() {
        val voltarInicial = Intent(this, MainActivity::class.java)
        startActivity(voltarInicial)
    }
}