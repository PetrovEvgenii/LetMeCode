package com.example.lmcxml.domain.repository

import com.example.lmcxml.domain.models.Article

interface ArticleRepository {
    suspend fun get(): List<Article>
}