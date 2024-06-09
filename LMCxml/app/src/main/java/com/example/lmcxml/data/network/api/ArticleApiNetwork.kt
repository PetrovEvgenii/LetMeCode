package com.example.lmcxml.data.network.api

import com.example.lmcxml.data.network.model.ArticleNetwork
import com.example.lmcxml.data.network.model.Result
import com.squareup.moshi.Moshi
import java.net.HttpURLConnection
import java.net.URL

class ArticleApiNetwork(
    private val apiUrl: String,
    private val moshi: Moshi,
) : ArticleApi {
    override fun getArticles(): List<Result> {
        val url = URL(apiUrl)
        val con = url.openConnection() as HttpURLConnection
        val json = con.inputStream.bufferedReader().use { it.readText() }


        val jsonAdapter = moshi.adapter(ArticleNetwork::class.java)
        val news = jsonAdapter.fromJson(json) as ArticleNetwork


        return news.results
    }
}