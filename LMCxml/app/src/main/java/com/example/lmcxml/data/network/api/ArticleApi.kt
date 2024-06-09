package com.example.lmcxml.data.network.api

import com.example.lmcxml.data.network.model.Result

interface ArticleApi {

     fun getArticles(): List<Result>
}