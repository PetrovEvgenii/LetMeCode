package com.example.lmcxml.data.mappers

import com.example.lmcxml.data.network.model.Result
import com.example.lmcxml.domain.models.Article

fun Result.toDomain(): Article {
    return Article(
        title = title ?: "",
        abstract = abstract ?: "",
        byLine = byline ?: "",
       publishedDate = published_date,
        imageUrl = multimedia?.get(2)?.url ?: "",
    )
}


