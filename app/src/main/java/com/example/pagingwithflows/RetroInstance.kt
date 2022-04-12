package com.example.pagingwithflows

import com.example.pagingwithflows.server_data.Info
import com.example.pagingwithflows.server_data.final_result
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroInstance {
    @GET("character")
    suspend fun getData(@Query("page")page_no:Int):final_result

    @GET("character/")
    suspend fun getData1():final_result
}