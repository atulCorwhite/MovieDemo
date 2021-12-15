package com.example.moviedemo.network
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor




object RetrofitBuilder {
    private var logging = HttpLoggingInterceptor()
    val apiService: ApiService by lazy { getRetrofit().create(ApiService::class.java) }
    val apiServicee: ApiService by lazy { getRetrofit().create(ApiService::class.java) }

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private fun getRetrofit():Retrofit{
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging) // <-- this is the important line!
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(httpClient.build())
            .build()
        return retrofit
       /* return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(getHttpLogClient())
            .build()*/
    }

    private fun getHttpLogClient(): OkHttpClient {
        val client=OkHttpClient.Builder().build()
        logging.level=HttpLoggingInterceptor.Level.BODY
        client.networkInterceptors
        return client
    }

}