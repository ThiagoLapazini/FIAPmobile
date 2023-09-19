package com.example.appfiapreciclagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appfiapreciclagem.adapter.LocalAdapter
import com.example.appfiapreciclagem.databinding.ActivityMainBinding
import com.example.appfiapreciclagem.model.PontosColeta

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var localAdapter: LocalAdapter
    private var localList: MutableList<PontosColeta> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        localAdapter = LocalAdapter(this, localList)
        recyclerView.adapter = localAdapter
        getLista()

    }

    private fun getLista() {
        val local1 = PontosColeta(
            "Eco Ponto Vila Mariana",
            "Eco ponto vila mariana é bem legal!"
        )
        localList.add(local1)
        val local2 = PontosColeta(
            "Eco Ponto ABREE",
            "Ecoponto - ABREE - Associação Brasileira de Reciclagem de Eletroeletrônicos e Eletrodomésticos"
        )
        localList.add(local2)
        val local3 = PontosColeta(
            "Lixo do Futuro",
            "Lixo do Futuro é bem legal!"
        )
        localList.add(local3)
        val local4 = PontosColeta(
            "Green Eletron",
            "Green Eletron é bem legal!"
        )
        localList.add(local4)
        val local5 = PontosColeta(
            "Sucata Digital",
            "Sucata Digital é bem legal!"
        )
        localList.add(local5)

    }
}