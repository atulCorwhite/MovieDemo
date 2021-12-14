package com.example.moviedemo.network

import com.example.moviedemo.model.MovieInfoResponse
import com.example.moviedemo.model.Results
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/3/movie/popular?api_key=aecfaa3cec82d0f9182bbf8e19b77f75")
    suspend fun getInfo(): MovieInfoResponse
}