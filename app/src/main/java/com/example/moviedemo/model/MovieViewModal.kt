package com.example.moviedemo.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedemo.network.RetrofitBuilder
import kotlinx.coroutines.launch

enum class MovieApiStatus { LOADING, ERROR, DONE }
class MovieViewModal : ViewModel() {
    private var _movieItem = MutableLiveData<List<Results>>()
    val movieItem: MutableLiveData<List<Results>> get() = _movieItem
    private var _status = MutableLiveData<MovieApiStatus>()
    val status: MutableLiveData<MovieApiStatus> get() = _status
    var _favMovies = MutableLiveData<List<Results>>()
    val favMovies: MutableLiveData<List<Results>> get() = _favMovies
    private var _original_language = MutableLiveData<String>()
    val original_language: MutableLiveData<String> get() = _original_language

    private var _movieTitle = MutableLiveData<String>()
    val movieTitle: MutableLiveData<String> get() = _movieTitle

    private var _movieImageUrl = MutableLiveData<String>()
    val movieImageUrl: MutableLiveData<String> get() = _movieImageUrl
    private var _backdrop_path = MutableLiveData<String>()
    val backdrop_path: MutableLiveData<String> get() = _backdrop_path

    private var _movieReleaseDate = MutableLiveData<String>()
    val movieReleaseDate: MutableLiveData<String> get() = _movieReleaseDate
    private var _movieDescription = MutableLiveData<String>()
    val movieDescription: MutableLiveData<String> get() = _movieDescription
    private var _movieVoteAverage = MutableLiveData<String>()
    val movieVoteAverage: MutableLiveData<String> get() = _movieVoteAverage

    init {
        getMovie()
    }

    private fun getMovie() {
        viewModelScope.launch {
            _status.value= MovieApiStatus.LOADING
            try {
                _movieItem.value= RetrofitBuilder.apiService.getInfo().results
                _status.value = MovieApiStatus.DONE
            }catch (e:Exception){
                Log.d("viewModelScope", "error --> $e")
                _status.value = MovieApiStatus.ERROR
                movieItem.value = listOf()
            }
        }

    }

    fun getMovieByID(id: Int?) {

    }

    fun sortMoviesByReleasedDate() {

    }

}