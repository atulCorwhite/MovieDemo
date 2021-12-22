package com.example.moviedemo.movie

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.moviedemo.R
import com.example.moviedemo.databinding.FragmentHomeBinding
import com.example.moviedemo.model.MovieType
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
                findNavController().navigate(R.id.favouriteFragment)
            }
            R.id.drama->{
                viewModel.getMovieByID(MovieType.DRAMA.id)
            }
            R.id.history->{
                viewModel.getMovieByID(MovieType.HISTORY.id)
            }
            R.id.war->{
                viewModel.getMovieByID(MovieType.WAR.id)
            }
            R.id.western->{
                viewModel.getMovieByID(MovieType.WESTERN.id)
            }
            R.id.thriller->{
                viewModel.getMovieByID(MovieType.THRILLER.id)
            }
            R.id.tv_movie->{
                viewModel.getMovieByID(MovieType.TV_MOVIE.id)
            }
            R.id.science_fiction->{
                viewModel.getMovieByID(MovieType.SCIENCE_FICTION.id)
            }
            R.id.romance->{
                viewModel.getMovieByID(MovieType.ROMANCE.id)
            }
            R.id.mystery->{
                viewModel.getMovieByID(MovieType.MYSTERY.id)
            }
            R.id.music->{
                viewModel.getMovieByID(MovieType.MUSIC.id)
            }
            R.id.horror->{
                viewModel.getMovieByID(MovieType.HORROR.id)
            }
            R.id.fantasy->{
                viewModel.getMovieByID(MovieType.FANTASY.id)
            }
            R.id.family->{
                viewModel.getMovieByID(MovieType.FAMILY.id)
            }
            R.id.documentary->{
                viewModel.getMovieByID(MovieType.FAMILY.id)
            }
            R.id.action->{
                viewModel.getMovieByID(MovieType.ACTION.id)
            }
            R.id.adventure->{
                viewModel.getMovieByID(MovieType.ADVENTURE.id)
            }
            R.id.crime->{
                viewModel.getMovieByID(MovieType.CRIME.id)
            }
            R.id.animation->{
                viewModel.getMovieByID(MovieType.ANIMATION.id)
            }
            R.id.comedy->{
                viewModel.getMovieByID(MovieType.COMEDY.id)
            }
            R.id.no_filter->{
                viewModel.getMovieByID(null)
            }
            R.id.sort_released_date->{
                viewModel.sortMoviesByReleasedDate()
            }
        }
    }

}