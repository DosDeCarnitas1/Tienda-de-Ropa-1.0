package com.example.tiendaderopa10.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Tienda de Ropa 1.0 arranca en el año 1991 con clara vocación internacional\n" +
                "y con la intención de vestir a jóvenes comprometidos con su entorno," +
                "que viven en comunidad y se relacionan entre sí.\n" +
                "Jóvenes que visten de forma relajada, huyendo de los estereotipos y que quieren sentirse bien con lo que llevan."
    }
    val text: LiveData<String> = _text
}