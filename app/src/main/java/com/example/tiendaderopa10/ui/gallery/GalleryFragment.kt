package com.example.tiendaderopa10.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.fragment.app.Fragment
import com.example.tiendaderopa10.R
import com.example.tiendaderopa10.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        // Configurar los listeners para cada ImageButton
        setupImageButtonListeners()

        return binding.root
    }

    private fun setupImageButtonListeners() {
        binding.img1.setOnClickListener {
            navigateToProductDetail(R.mipmap.chamarra, "Chamarra biker color negro\n" +
                    "\n" + "fabricada en piel de borrego pelibuey forro textil, etiquetas internas de piel grabadas con láser, " +
                    "cinto ajustable de piel, botones, remaches y hebillas fabricados en metal.\n" +
                    "\n" + "Precio:" + "\$ 3,999.00")
        }
        binding.img2.setOnClickListener {
            navigateToProductDetail(R.mipmap.pantalones, "Pantalón Bestial Club.\n" +
                    "\n" +
                    "De la primera colección de pantalones Thoro, fabricado 100% en mezclilla color azul claro, " +
                    "botones y etiquetas exclusivas de Bestial Club con serigrafia en la parte trasera color blanco.\n" +
                    "\n" + "Precio:" + "\$ 899.00")
        }
        binding.img3.setOnClickListener {
            navigateToProductDetail(R.mipmap.botas, "Las Fango un clásico de thoro.\n" +
                    "\n" + "Botas (botines) chelsea fabricadas en piel de res color negro con suela gruesa y elasticos laterales.\n" +
                    "\n" + "Precio:" + "\$ 1,599.00")
        }
        binding.img4.setOnClickListener {
            navigateToProductDetail(R.mipmap.paliacate, "Paliacate en color rojo legendary cowboys.\n" +
                    "\n" +
                    "Parte de nuestra colección Bestial Club.\n" +
                    "\n" + "Tamaño: 60 cm x 60cm.\n" +
                    "\n" + "Material: Charmeuse satinado.\n" +
                    "\n" + "Precio:" + "\$ 399.00")
        }
        binding.img5.setOnClickListener {
            navigateToProductDetail(R.mipmap.gorra, "Gorra wild cowboys\n" +
                    "\n" + "Gorra sin extructura rigida con visera plana en color azul, cordon decorativo y diseño bordado en color blanco.\n" +
                    "\n" + "Precio:" + "\$ 799.00")
        }
        binding.img6.setOnClickListener {
            navigateToProductDetail(R.mipmap.calcetines, "Calceta clásica\n" +
                    "\n" +
                    "En color negro con blanco de la nueva colección bestial club.\n" +
                    "\n" +
                    "(85% algodón, 10 nylon, 5% elastano)\n" +
                    "\n" + "\$ 169.00")
        }
    }

    private fun navigateToProductDetail(imageResId: Int, description: String) {
        val bundle = Bundle().apply {
            putInt("imageResId", imageResId)
            putString("description", description)
        }
        findNavController().navigate(R.id.action_navGallery_to_fragmentDetalles, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}