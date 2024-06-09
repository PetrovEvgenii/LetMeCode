package com.example.lmcxml.presentation.articles


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.lmcxml.core.di.DiProvider
import com.example.lmcxml.domain.models.Article
import com.example.lmcxml.domain.repository.ArticleRepository
import com.example.lmcxml.domain.usecase.GetArticlesUseCase
import kotlinx.coroutines.launch

internal class ArticlesViewModel(private val getArticlesUseCase: GetArticlesUseCase) :
    ViewModel() {

    private val _articles = MutableLiveData<List<Article>>(emptyList())
    val articles: LiveData<List<Article>> = _articles


    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            val articles = getArticlesUseCase.execute()
            _articles.postValue(articles)
        }
    }

    fun refresh() {
        load()
    }


    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras,
            ): T {
                val di = DiProvider.di
                val getArticleUc by lazy {
                    GetArticlesUseCase(
                        articleRepository = di.get(ArticleRepository::class)
                    )
                }

                return ArticlesViewModel(
                    getArticlesUseCase =
                    getArticleUc
                ) as T
            }
        }
    }
}