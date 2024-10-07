package com.example.tiendaderopa10.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tiendaderopa10.R
import com.example.tiendaderopa10.databinding.FragmentSlideshowBinding

// Clase Cliente para almacenar los datos
data class Cliente(val nombre: String, val telefono: String, val correo: String, val ropaSeleccionada: String)

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)

        // Configurar el Spinner con opciones del string-array
        setupSpinner()

        // Configurar el botón Aceptar para guardar los datos y mostrar el Toast
        binding.btnAceptar.setOnClickListener {
            registrarDatos()
        }

        // Configurar el botón Cancelar para limpiar los campos
        binding.btnCancelar.setOnClickListener {
            limpiarCampos()
        }

        return binding.root
    }

    private fun setupSpinner() {
        // Usar el string-array definido en strings.xml para el Spinner
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.antiguedad, // Referencia al string-array
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spnRopa.adapter = adapter
    }

    private fun registrarDatos() {
        // Obtener los datos de los campos
        val nombre = binding.edtNombre.text.toString()
        val telefono = binding.edtTelefono.text.toString()
        val correo = binding.edtCorreo.text.toString()
        val ropaSeleccionada = binding.spnRopa.selectedItem.toString()

        // Validar que todos los campos estén llenos
        if (nombre.isNotEmpty() && telefono.isNotEmpty() && correo.isNotEmpty()) {
            // Crear un objeto Cliente con los datos
            val cliente = Cliente(nombre, telefono, correo, ropaSeleccionada)

            // Mostrar los datos registrados en un Toast
            Toast.makeText(
                requireContext(),
                "Nombre: ${cliente.nombre}\nTeléfono: ${cliente.telefono}\nCorreo: ${cliente.correo}\nRopa: ${cliente.ropaSeleccionada}",
                Toast.LENGTH_LONG
            ).show()
        } else {
            // Mostrar un mensaje de error si faltan datos
            Toast.makeText(requireContext(), "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun limpiarCampos() {
        // Limpiar los campos de texto y resetear el Spinner
        binding.edtNombre.text.clear()
        binding.edtTelefono.text.clear()
        binding.edtCorreo.text.clear()
        binding.spnRopa.setSelection(0) // Seleccionar la primera opción
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
