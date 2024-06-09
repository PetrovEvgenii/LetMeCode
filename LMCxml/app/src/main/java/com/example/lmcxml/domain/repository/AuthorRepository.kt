package com.example.lmcxml.domain.repository

import com.example.lmcxml.domain.models.Author

interface AuthorRepository {
    fun get(): List<Author>
}