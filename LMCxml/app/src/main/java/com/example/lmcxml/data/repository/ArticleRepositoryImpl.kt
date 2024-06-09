package com.example.lmcxml.data.repository

import com.example.lmcxml.data.mappers.toDomain
import com.example.lmcxml.domain.models.Article
import com.example.lmcxml.data.network.api.ArticleApi
import com.example.lmcxml.domain.repository.ArticleRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext


class ArticleRepositoryImpl(
    private val articleApi: ArticleApi,
    private val dispatcher: CoroutineDispatcher,
) : ArticleRepository {
    override suspend fun get(): List<Article> = withContext(dispatcher) {
        val sections = articleApi
            .getArticles()
            .map {
                it.toDomain()
            }
        sections
    }

}


