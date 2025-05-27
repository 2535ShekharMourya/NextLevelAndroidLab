package com.azad.masterrecyclerview.networking

import com.azad.masterrecyclerview.datamodel.postsData.Posts
import com.azad.masterrecyclerview.datamodel.userData.Users
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitInstance {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/") // dummy
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
interface ApiService {
    @GET("users")
    suspend fun getUsers(): Users

    @GET("posts")
    suspend fun getPosts(): Posts


}