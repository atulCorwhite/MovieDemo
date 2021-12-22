package com.example.moviedemo.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedemo.databinding.GridViewItemBinding
import com.example.moviedemo.model.Results

class MovieGridAdapter(var flag: String) : ListAdapter<Results, MovieGridAdapter.MovieViewHolder>(DiffCalBack) {
    lateinit var action:NavDirections

    inner class MovieViewHolder(private var binding: GridViewItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Results?) {
          binding.movie=item
            binding.executePendingBindings()

            binding.movieImage.setOnClickListener {
                if (flag == "home"){
                    if (item != null) {
                        action=HomeFragmentDirections.homeToDetail(
                            item.title,
                            item.poster_path,
                            item.backdrop_path,
                            item.original_language,
                            item.release_date,
                            item.overview,
                            item.vote_average.toString()
                        )
                    }
                }
                else{
         /*        action=HomeFragmentDirections.homeToFavourite(
                     item.title,
                     item.poster_path,
                     item.release_date,
                     item.overview,
                     item.vote_average.toString(),
                     item.isFavMovie.toString(),
                     item.backdrop_path,
                     item.movieType.toString()
                 )*/
                }
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieGridAdapter.MovieViewHolder {
        return MovieViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MovieGridAdapter.MovieViewHolder, position: Int) {
      val item=getItem(position)
        holder.bind(item)
    }

}

object DiffCalBack :DiffUtil.ItemCallback<Results>(){
    override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
       return oldItem.title==newItem.title
    }

}
