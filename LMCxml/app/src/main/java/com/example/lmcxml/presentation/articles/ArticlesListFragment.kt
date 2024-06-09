package com.example.lmcxml.presentation.articles

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lmcxml.R
import com.example.lmcxml.databinding.FragmetArticleListBinding
import com.example.lmcxml.presentation.SpaceDecoration


class ArticlesListFragment : Fragment(R.layout.fragmet_article_list) {

    private val articlesViewModel by viewModels<ArticlesViewModel> { ArticlesViewModel.Factory }
    private val adapter = ArticlesAdapter {
        articlesViewModel.refresh()

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmetArticleListBinding.bind(view)

        binding.articlesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.articlesRecyclerView.addItemDecoration(
            SpaceDecoration(
                spaceSize = resources.getDimensionPixelSize(
                    R.dimen.padding10
                )
            )
        )
        binding.articlesRecyclerView.adapter = adapter

        binding.swiperefresh.setOnRefreshListener {

            articlesViewModel.refresh()
            binding.swiperefresh.isRefreshing = false
        }

        binding.searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                //TODO
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //TODO
                return true
            }


        })



        articlesViewModel.articles.observe(viewLifecycleOwner) {
            adapter.items = it
        }
    }


}
