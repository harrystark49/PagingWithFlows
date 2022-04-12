package com.example.pagingwithflows.server_data

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)