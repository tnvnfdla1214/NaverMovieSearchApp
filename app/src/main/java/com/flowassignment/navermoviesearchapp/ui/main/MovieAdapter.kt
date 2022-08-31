package com.flowassignment.navermoviesearchapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flowassignment.navermoviesearchapp.databinding.ItemMovieBinding
import com.flowassignment.navermoviesearchapp.databinding.ItemMovieBindingImpl
import com.flowassignment.navermoviesearchapp.domain.entity.Movie

class MovieAdapter(
    private var list: List<Movie>,
    private val onClick: (Movie) -> Unit,
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieBindingImpl.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick = onClick,
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])
    override fun getItemCount(): Int = list.size

    fun updateList(updatedList: List<Movie>) {
        list = updatedList
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ItemMovieBinding,
        onClick: (Movie) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onClick(binding.model ?: return@setOnClickListener)
            }
        }

        fun bind(item: Movie) {
            binding.model = item
        }
    }

}