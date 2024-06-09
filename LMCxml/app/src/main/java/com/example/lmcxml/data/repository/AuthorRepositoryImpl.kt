package com.example.lmcxml.data.repository

import com.example.lmcxml.R
import com.example.lmcxml.domain.models.Author
import com.example.lmcxml.domain.repository.AuthorRepository


class AuthorRepositoryImpl(
) : AuthorRepository {
    override fun get(): List<Author> {
        var authors: List<Author> = mutableListOf(
          Author("I couldn't find API  for the list of authors", R.drawable.avatar1),
          Author("I couldn't find API  for the list of authors",R.drawable.avatar2),
          Author("I couldn't find API  for the list of authors",R.drawable.avatar3),
          Author("I couldn't find API  for the list of authors",R.drawable.avatar4),
          Author("I couldn't find API  for the list of authors",R.drawable.avatar5),
          Author("I couldn't find API  for the list of authors",R.drawable.avatar6),
          Author("I couldn't find API  for the list of authors",R.drawable.avatar7),
          Author("I couldn't find API  for the list of authors",R.drawable.avatar7),
          Author("I couldn't find API  for the list of authors",R.drawable.avatar8),
            Author("I couldn't find API  for the list of authors", R.drawable.avatar1),
            Author("I couldn't find API  for the list of authors",R.drawable.avatar2),
            Author("I couldn't find API  for the list of authors",R.drawable.avatar3),
            Author("I couldn't find API  for the list of authors",R.drawable.avatar4),
            Author("I couldn't find API  for the list of authors",R.drawable.avatar5),
            Author("I couldn't find API  for the list of authors",R.drawable.avatar6),
            Author("I couldn't find API  for the list of authors",R.drawable.avatar7),
            Author("I couldn't find API  for the list of authors",R.drawable.avatar4),
            Author("I couldn't find API  for the list of authors",R.drawable.avatar1),

        )
        return authors
    }


}