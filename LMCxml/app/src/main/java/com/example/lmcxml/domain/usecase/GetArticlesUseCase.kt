package com.example.lmcxml.domain.usecase

import com.example.lmcxml.domain.models.Article
import com.example.lmcxml.domain.repository.ArticleRepository

class GetArticlesUseCase(private val articleRepository: ArticleRepository) {

    suspend fun execute(): List<Article> {
        return articleRepository.get()
    }
}