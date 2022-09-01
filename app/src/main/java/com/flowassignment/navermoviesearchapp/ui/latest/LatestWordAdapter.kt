package com.flowassignment.navermoviesearchapp.ui.latest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flowassignment.navermoviesearchapp.databinding.ItemTextBinding
import com.flowassignment.navermoviesearchapp.databinding.ItemTextBindingImpl

class LatestWordAdapter(
    private var list: List<String>,
    private val onClick: (String) -> Unit,
) : RecyclerView.Adapter<LatestWordAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTextBindingImpl.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick = onClick,
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])
    override fun getItemCount(): Int = list.size

    fun updateList(updatedList: List<String>) {
        list = updatedList
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ItemTextBinding,
        onClick: (String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onClick(binding.word ?: return@setOnClickListener)
            }
        }

        fun bind(item: String) {
            binding.word = item
        }
    }

    companion object {
        const val KEY_WORD = "KEY_WORD"
    }

}