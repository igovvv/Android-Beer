package com.example.beercafesv1.screens.cafelist


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.beercafesv1.R
import com.example.beercafesv1.databinding.FragmentCafeBinding
import com.example.beercafesv1.screens.cafe.CafeViewModel
import com.example.beercafesv1.screens.cafe.CafeViewModelFactory


class CafeFragment : Fragment(){
    private lateinit var viewModel: CafeViewModel
    private lateinit var binding: FragmentCafeBinding
    private val args: CafeFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cafe, container, false)

        val cafe = CafeFragmentArgs.fromBundle(
            requireArguments()).beerCafe
        val fact = CafeViewModelFactory(cafe)
        viewModel = ViewModelProvider(this, fact).get(
            CafeViewModel::class.java
        )
        binding.cafeViewModel = viewModel

            return binding.root
    }

}
