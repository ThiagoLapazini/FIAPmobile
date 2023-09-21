package com.example.appfiapreciclagem

import LocalAdapter
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appfiapreciclagem.databinding.ActivityMainBinding
import com.example.appfiapreciclagem.model.PontosColeta
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var localAdapter: LocalAdapter
    private var localList: MutableList<PontosColeta> = mutableListOf()
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var lastKnownLocation: Location

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            getLastLocation()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        localAdapter = LocalAdapter(this, localList)
        recyclerView.adapter = localAdapter

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        requestPermissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)

        getLista()

        binding.btApoiadores1.setOnClickListener {
            val apoiadores = Intent(this, ApoiadoresTela::class.java)
            startActivity(apoiadores)
        }
        binding.blogTela1.setOnClickListener {
            val telaBlog = Intent(this, TelaBlog::class.java)
            startActivity(telaBlog)
        }

    }

    private fun getLista() {
        val local1Location = Location("")
        local1Location.latitude = -23.59275
        local1Location.longitude = -46.63496
        val local1 = PontosColeta(
            "Eco Ponto Vila Mariana",
            "Eco ponto vila mariana é bem legal!",
            local1Location,
        )
        localList.add(local1)

        val local2Location = Location("")
        local2Location.latitude = -27.431916699126088
        local2Location.longitude = -48.454454446235296
        val local2 = PontosColeta(
            "Eco Ponto ABREE",
            "Ecoponto - ABREE - Associação Brasileira de Reciclagem de Eletroeletrônicos e Eletrodomésticos",
            local2Location,
        )
        localList.add(local2)

        val local3Location = Location("")
        local3Location.latitude = -27.439512861830085
        local3Location.longitude = -48.386878803712406
        val local3 = PontosColeta(
            "Lixo do Futuro",
            "Lixo do Futuro é bem legal!",
            local3Location,
        )
        localList.add(local3)

        val local4Location = Location("")
        local4Location.latitude = -23.562519389696455
        local4Location.longitude = -46.65523374195634
        val local4 = PontosColeta(
            "Green Eletron",
            "Green Eletron é bem legal!",
            local4Location,
        )
        localList.add(local4)
        val local5Location = Location("")
        local5Location.latitude = -23.56251
        local5Location.longitude = -46.65523
        val local5 = PontosColeta(
            "Sucata Digital",
            "Sucata Digital é bem legal!",
            local5Location,
        )
        localList.add(local5)

    }

    private fun getLastLocation() {
        val locationRequest = LocationRequest.create()
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
            .setInterval(10000)
            .setFastestInterval(5000)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    lastKnownLocation = location
                    updateDistances()
                }
            }
    }

    private fun updateDistances() {
        if (::lastKnownLocation.isInitialized) {
            for (local in localList) {
                val coletaLocation = local.location
                val distance = lastKnownLocation.distanceTo(coletaLocation) / 1000
                local.distance = distance
            }


            localList.sortBy { it.distance }


            localAdapter.notifyDataSetChanged()
        }

    }
}


