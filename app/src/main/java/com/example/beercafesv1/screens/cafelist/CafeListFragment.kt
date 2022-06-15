package com.example.beercafesv1.screens.cafelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.beercafesv1.databinding.FragmentCafeListBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beercafesv1.R
import com.example.beercafesv1.models.BeerCafeItem


class CafeListFragment : Fragment() {

    private val viewModel: CafeListViewModel by viewModels()
    private lateinit var binding: FragmentCafeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cafe_list, container, false)
        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        val adapter = CafeListAdapter(BeerCafeClickListener {
            viewModel.onCafeClicked(it) })

        binding.cafeList.adapter = adapter

        val manager = LinearLayoutManager(activity)
        binding.cafeList.layoutManager = manager

        viewModel.cafes.observe(viewLifecycleOwner, Observer {
        it?.let {
            adapter.submitList(it.toList())
        }
        })

        viewModel.cafe.observe(viewLifecycleOwner, Observer {
            it?.let {
                navigateToCafeDetail(it!!)
                viewModel.navigateToDetailFinished()
            }
        })

        binding.setLifecycleOwner(this)
        return binding.root
    }
    fun navigateToCafeDetail(cafe: BeerCafeItem){
        requireView().findNavController().navigate(CafeListFragmentDirections.actionCafeListFragmentToCafeFragment(cafe))
    }
}

