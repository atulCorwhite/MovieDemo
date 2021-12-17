package com.example.moviedemo.movie

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
        when(item.itemId)
        {R.id.favorite_page ->{
                findNavController().navigate(R.id.homeToFavourite)
            }
            R.id.drama->{
               // viewModel.getMovieByID()
            }
        }
    }

}