package com.example.lmcxml.presentation.authors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lmcxml.R
import com.example.lmcxml.databinding.FragmetAuthorListBinding
import com.example.lmcxml.presentation.SpaceDecoration
//import com.example.lmcxml.presentation.author_details.AuthorDetailsFragment
import com.example.lmcxml.presentation.navigation.Navigator


class AuthorListFragment : Fragment(R.layout.fragmet_author_list) {

    private val authorsViewModel by viewModels<AuthorsViewModel> { AuthorsViewModel.Factory }
    private val adapter = AuthorsAdapter(){
//        authorsViewModel.studentClicked(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmetAuthorListBinding.bind(view)


        binding.authorsRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.authorsRecyclerView.addItemDecoration(
            SpaceDecoration(
                spaceSize = resources.getDimensionPixelSize(
                    R.dimen.padding10
                )
            )
        )
        binding.authorsRecyclerView.adapter = adapter

        authorsViewModel.authors.observe(viewLifecycleOwner) {
            adapter.items = it
        }


    }


}
