package com.example.moviedemo.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviedemo.R
import com.example.moviedemo.databinding.FragmentHomeBinding
import com.example.moviedemo.model.MovieViewModal


class HomeFragment: Fragment() {
    lateinit var binding:FragmentHomeBinding
    val viewModel:MovieViewModal by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(inflater)
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner=this
        binding.movieRecyclerView.adapter = MovieGridAdapter("Home")
        binding.viewModal= viewModel
        return binding.root
    }
    fun goToNextFragment() {
//        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
        Toast.makeText(requireContext(), "goToNextFragment()", Toast.LENGTH_LONG).show()
    }


}