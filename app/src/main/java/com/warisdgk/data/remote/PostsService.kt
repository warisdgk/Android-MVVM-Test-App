package com.warisdgk.data.remote

import com.warisdgk.BuildConfig
import com.warisdgk.data.entities.Post
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsService {

    @GET("posts/{id}")
    suspend fun fetchPost(
        @Path("id") id: Int,
    ): Response<Post>

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create(): PostsService {
            return composeRetrofitBuilder()
        }

        private fun composeRetrofitBuilder(): PostsService {

            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return if (BuildConfig.DEBUG) {
                Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(PostsService::class.java)
            } else {
                Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(PostsService::class.java)
            }

        }
    }

}