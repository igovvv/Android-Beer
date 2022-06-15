package com.example.beercafesv1.screens

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.beercafesv1.R
import com.example.beercafesv1.databinding.FragmentMainBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CafeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,
            R.layout.fragment_main,container,false)

        binding.listButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_cafeListFragment)
        }
            binding.favouritesButton.setOnClickListener { view: View ->
                view.findNavController().navigate(R.id.action_mainFragment_to_favoritesFragment)
            }
        setHasOptionsMenu(true)
        return binding.root
    }
}
