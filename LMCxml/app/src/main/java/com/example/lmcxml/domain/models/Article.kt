package com.example.lmcxml.domain.models

import java.time.ZonedDateTime

data class Article (
    val title : String?,
    val abstract: String?,
    val byLine: String?,
    val publishedDate: ZonedDateTime?,
    val imageUrl: String?,

    )