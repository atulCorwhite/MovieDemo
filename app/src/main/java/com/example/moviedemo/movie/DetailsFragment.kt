package com.example.moviedemo.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviedemo.databinding.FragmentDetailsBinding
import com.example.moviedemo.model.MovieViewModal

class DetailsFragment:Fragment() {
    private val viewModal:MovieViewModal by viewModels()
    lateinit var movieTitle: String
    lateinit var movieImageUrl: String
    lateinit var backdrop_path: String
    lateinit var original_language: String
    lateinit var movieReleaseDate: String
    lateinit var movieDescription: String
    lateinit var movieVoteAverage: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            movieTitle=it.getString(MOVIETITLE).toString()
            movieImageUrl=it.getString(MOVIEIMAGEURL).toString()
            backdrop_path=it.getString(BACKDROPPATH).toString()
            movieReleaseDate=it.getString(MOVIERELEASEDATE).toString()
            original_language=it.getString(ORIGINALLANGUAGE).toString()
            movieDescription=it.getString(MOVIEDESCRIPTION).toString()
            movieVoteAverage=it.getString(MOVIEVOTEAVERAGE).toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Overview"
        viewModal.movieTitle.value=movieTitle
        viewModal.movieImageUrl.value=movieImageUrl
        viewModal.backdrop_path.value=backdrop_path
        viewModal.original_language.value=original_language
        viewModal.movieDescription.value=movieDescription
        viewModal.movieReleaseDate.value=movieReleaseDate
        viewModal.movieVoteAverage.value=movieVoteAverage

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding=FragmentDetailsBinding.inflate(inflater,container,false)
        binding.viewModal
        binding.lifecycleOwner=this

        return binding.root
    }

    companion object {
        const val MOVIETITLE = "movieTitle"
        const val MOVIEIMAGEURL = "movieImageUrl"
        const val BACKDROPPATH = "backdrop_path"
        const val ORIGINALLANGUAGE = "original_language"
        const val MOVIERELEASEDATE = "movieReleaseDate"
        const val MOVIEDESCRIPTION = "movieDescription"
        const val MOVIEVOTEAVERAGE = "movieVoteAverage"
    }
}