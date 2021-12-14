package com.example.moviedemo.utility

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.moviedemo.R
import com.example.moviedemo.model.MovieApiStatus
import com.example.moviedemo.model.Results
import com.example.moviedemo.movie.MovieGridAdapter


    @BindingAdapter("listData")
    fun RecyclerView.bindRecyclerView(data: List<Results>?) {
        val adapter = this.adapter as MovieGridAdapter
        adapter.submitList(data)
    }
    @BindingAdapter("movieApiStatus")
    fun ImageView.bindApiStatus(status: MovieApiStatus?) {
        when (status) {
            MovieApiStatus.LOADING -> {
                this.visibility = View.VISIBLE
                this.setImageResource(R.drawable.loading_animation)
            }
            MovieApiStatus.ERROR -> {
                this.visibility = View.VISIBLE
                this.setImageResource(R.drawable.ic_connection_error)
            }
            MovieApiStatus.DONE -> {
                this.visibility = View.GONE
            }
        }
    }
    @BindingAdapter("imageUrl")
    fun ImageView.bindImage(imageUrl: String?) {
        imageUrl?.let {
            // val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
            this.load("https://image.tmdb.org/t/p/w500" + imageUrl) {
                placeholder(R.drawable.loading_animation)
                error(R.drawable.ic_broken_image)
            }
        }
    }
