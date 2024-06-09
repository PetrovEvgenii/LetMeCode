package com.example.lmcxml.presentation.authors


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lmcxml.databinding.ItemAuthorBinding
import com.example.lmcxml.domain.models.Author

class AuthorsAdapter (private val itemClick: (Author)->Unit
) : RecyclerView.Adapter<AuthorsAdapter.AuthorHolder>(){
    var items: List<Author> = emptyList()
        set(newList){
            field = newList
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AuthorHolder {
        return AuthorHolder(
            binding = ItemAuthorBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: AuthorHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class AuthorHolder(private val binding: ItemAuthorBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(author: Author) {
            binding.name.text = author.name
            binding.image.setImageResource(author.imageUrl)
            binding.root.setOnClickListener {
                itemClick.invoke(author)
            }

        }
    }}