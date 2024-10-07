package com.example.tiendaderopa10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

private const val ARG_IMAGE_RES = "imageResId"
private const val ARG_DESCRIPTION = "description"

class fragment_detalles : Fragment() {

    private var imageResId: Int? = null
    private var description: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageResId = it.getInt(ARG_IMAGE_RES)
            description = it.getString(ARG_DESCRIPTION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detalles, container, false)

        // Encontrar las vistas de la imagen y el texto
        val imageView: ImageView = view.findViewById(R.id.productImage)
        val descriptionTextView: TextView = view.findViewById(R.id.txtDetalles)

        // Configurar la imagen y la descripción si existen
        imageResId?.let { imageView.setImageResource(it) }
        descriptionTextView.text = description

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(imageResId: Int, description: String) =
            fragment_detalles().apply {
                arguments = Bundle().apply {
                    putInt("imageResId", imageResId)
                    putString("description", description)
                }
            }
    }
}