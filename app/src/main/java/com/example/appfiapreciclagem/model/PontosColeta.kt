package com.example.appfiapreciclagem.model

import android.location.Location


data class PontosColeta(
    val localNome: String,
    val localDescricao: String,
    val location: Location,
    var distance: Float = 0f
)