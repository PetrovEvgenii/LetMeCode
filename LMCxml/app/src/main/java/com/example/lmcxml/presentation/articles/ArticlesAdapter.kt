package com.example.lmcxml.presentation.articles


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lmcxml.databinding.ItemArticleBinding
import com.example.lmcxml.domain.models.Article
import com.example.lmcxml.presentation.utils.formatDateTime

class ArticlesAdapter (
    private val itemClick: (Article)->Unit,
) : RecyclerView.Adapter<ArticlesAdapter.ReviewHolder>(){
    var items: List<Article> = emptyList()
        set(newList){
            field = newList
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReviewHolder {
        return ReviewHolder(
            binding = ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ReviewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ReviewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(article: Article) {
            binding.title.text = article.title
            binding.abstr.text = article.abstract
            binding.byLine.text = article.byLine
            binding.publishedDate.text = formatDateTime( article.publishedDate)
            binding.image.setImageURI(article.imageUrl)
            binding.root.setOnClickListener {
                itemClick.invoke(article)
            }

        }
    }}