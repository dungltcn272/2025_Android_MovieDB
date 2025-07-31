package com.nhom4.androidmoviedb.core.platform

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : Any, VH : RecyclerView.ViewHolder>(
    private val diffCallback: DiffUtil.ItemCallback<T>
) : RecyclerView.Adapter<VH>() {

    private val differ = AsyncListDiffer(this, diffCallback)

    protected val items: List<T> get() = differ.currentList

    override fun getItemCount(): Int = items.size

    fun submitList(newList: List<T>) {
        differ.submitList(newList)
    }

    fun getItem(position: Int): T = items[position]
}

// Usage example in a RecyclerView Adapter:
// data class Movie(
//    val id: Int,
//    val title: String,
//    val posterPath: String
// )
// class MovieAdapter(
//    private val onItemClick: (Movie) -> Unit
// ) : BaseAdapter<Movie, MovieAdapter.MovieViewHolder>(DiffCallback) {
//
//    companion object {
//        private val DiffCallback = object : DiffUtil.ItemCallback<Movie>() {
//            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
//                return oldItem.id == newItem.id
//            }
//
//            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
//        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return MovieViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
//        holder.bind(getItem(position))
//    }
//
//    inner class MovieViewHolder(private val binding: ItemMovieBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(movie: Movie) {
//            binding.tvTitle.text = movie.title
//            Glide.with(binding.root.context)
//                .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
//                .into(binding.ivPoster)
//
//            binding.root.setOnClickListener {
//                onItemClick(movie)
//            }
//        }
//    }
// }
