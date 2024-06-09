package com.example.lmcxml.presentation.authors


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.lmcxml.core.di.DiProvider
import com.example.lmcxml.domain.models.Author
import com.example.lmcxml.domain.repository.AuthorRepository
import com.example.lmcxml.domain.usecase.GetAuthorsUseCase
//import com.example.lmcxml.presentation.author_details.AuthorDetails as FeatureCriticDetails


//internal sealed class Screen {
//    data object Nothing : Screen()
//    class AuthorDetails(val author: FeatureCriticDetails) : Screen()
//
//}

internal class AuthorsViewModel(private val getAuthorsUseCase: GetAuthorsUseCase) :
    ViewModel() {

    private val _authors = MutableLiveData<List<Author>>(emptyList())
    val authors: LiveData<List<Author>> = _authors

//    private val _screen = MutableLiveData<Screen>()
//    val screen: LiveData<Screen> = _screen

    init {
        load()
    }

    private fun load() {

        val authors = getAuthorsUseCase.execute()
        _authors.postValue(authors)
    }

//    fun studentClicked(author: Author) {
//        val authorDetails = FeatureCriticDetails(
//            imageUrl = author.imageUrl,
//            name = author.name,
//        )
//        _screen.value = Screen.AuthorDetails(author = authorDetails)
//        _screen.value = Screen.Nothing
//    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras,
            ): T {
                val di = DiProvider.di
                val getAuthorUc by lazy {
                    GetAuthorsUseCase(
                        authorRepository = di.get(AuthorRepository::class)
                    )
                }

                return AuthorsViewModel(
                    getAuthorsUseCase =
                    getAuthorUc
                ) as T
            }
        }
    }
}