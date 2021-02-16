package com.rkr.enfecproject.network

import com.rkr.enfecproject.model.RetroPosts
import com.rkr.enfecproject.model.RetroUsers

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

   // @GET("com")//https://jsonplaceholder.typicode.com/users
    //fun getDataFromUserAPI(@Query("users") query: String): Call<RecyclerListUsers>

    @GET("/users")
    fun getAllUsers(): Call<List<RetroUsers>>

    @GET("/posts")
    fun getAllPosts(): Call<List<RetroPosts>>


    /*@GET("com")//https://jsonplaceholder.typicode.com/posts
    fun getDataFromUserAPI(@Query("/") query: String): Call<RecyclerListUsers>


    @GET("com")//https://jsonplaceholder.typicode.com/posts
    fun getDataFromPostAPI(@Query("/") query: String): Call<RecyclerListPosts>*/

}