package com.example.lmcxml.data.network

import com.example.lmcxml.data.network.api.ArticleApi
import com.example.lmcxml.data.network.api.ArticleApiNetwork
import com.example.lmcxml.presentation.utils.DateTimeAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


fun provideMoshi(): Moshi {
    return Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .add(DateTimeAdapter())
        .build()

}

fun provideArticleApi(apiUrl: String, moshi: Moshi): ArticleApi {
    return ArticleApiNetwork(
        apiUrl = apiUrl,
        moshi = moshi
    )

}