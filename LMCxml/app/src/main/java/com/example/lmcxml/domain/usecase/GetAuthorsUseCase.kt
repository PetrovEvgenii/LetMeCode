package com.example.lmcxml.domain.usecase

import com.example.lmcxml.domain.models.Author
import com.example.lmcxml.domain.repository.AuthorRepository

class GetAuthorsUseCase(private val authorRepository: AuthorRepository) {

    fun execute(): List<Author> {
        return authorRepository.get()
    }
}