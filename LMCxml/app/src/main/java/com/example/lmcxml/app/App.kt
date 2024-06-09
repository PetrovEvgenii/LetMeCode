package com.example.lmcxml.app

import android.app.Application
import com.example.lmcxml.core.di.DiProvider
import com.example.lmcxml.data.repository.AuthorRepositoryImpl
import com.example.lmcxml.data.repository.ArticleRepositoryImpl
import com.example.lmcxml.di.GlobalDiImpl
import com.example.lmcxml.domain.repository.AuthorRepository
import com.example.lmcxml.domain.repository.ArticleRepository
import com.example.lmcxml.domain.usecase.GetAuthorsUseCase
import com.example.lmcxml.domain.usecase.GetArticlesUseCase
import com.example.lmcxml.data.network.api.ArticleApi
import com.example.lmcxml.data.network.provideArticleApi
import com.example.lmcxml.data.network.provideMoshi
import com.facebook.drawee.backends.pipeline.Fresco
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        setupDI()
    }

    private fun setupDI() {
        DiProvider.di = GlobalDiImpl()

        DiProvider.di.add(
            key = CoroutineDispatcher::class,
            object_ = Dispatchers.IO
        )
        DiProvider.di.add(
            key = Moshi::class,
            object_ = provideMoshi()
        )

        DiProvider.di.add(
            key = AuthorRepository::class,
            object_ = AuthorRepositoryImpl()
        )

        DiProvider.di.add(
            key = ArticleApi::class,
            object_ = provideArticleApi(
                apiUrl = "https://api.nytimes.com/svc/topstories/v2/world.json?api-key=GVycbZwvGAmDT03MMJMq9Ob49HBzF4tz",
                moshi = DiProvider.di.get(Moshi::class)
            )
        )

        DiProvider.di.add(
            key = ArticleRepository::class,
            object_ = ArticleRepositoryImpl(
                articleApi =  DiProvider.di.get(ArticleApi::class),
                dispatcher = DiProvider.di.get(CoroutineDispatcher::class),
            )
        )

        DiProvider.di.add(
            key = GetAuthorsUseCase::class,
            object_ = GetAuthorsUseCase(
                authorRepository = DiProvider.di.get(AuthorRepository::class),
            )
        )

        DiProvider.di.add(
            key = GetArticlesUseCase::class,
            object_ = GetArticlesUseCase(
                articleRepository = DiProvider.di.get(ArticleRepository::class),
            )
        )

    }
}