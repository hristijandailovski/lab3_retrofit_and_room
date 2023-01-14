package com.hfad.lab3_retrofit_and_room.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hfad.lab3_retrofit_and_room.R
import com.hfad.lab3_retrofit_and_room.model.Movie
import com.hfad.lab3_retrofit_and_room.ui.SecondFragment
import com.hfad.lab3_retrofit_and_room.ui.viewmodels.MovieFoundByIdViewModel

class MovieAdapter(
    private val movies:ArrayList<Movie> = ArrayList<Movie>(),
    private val parentFragmentManager:FragmentManager,
    private val movieFoundByIdViewModel: MovieFoundByIdViewModel
):
RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(view:View):RecyclerView.ViewHolder(view){
        private var imageView: ImageView = view.findViewById(R.id.movie_image)
        private var titleAndYearTextView: TextView= view.findViewById(R.id.movie_title_and_year)
        var parentFragmentManager: FragmentManager? = null
            get()=field
            set(value){
                field = value
            }
        var movieFoundByIdViewModel:MovieFoundByIdViewModel? =null
            get()=field
            set(value){
                field=value
            }
        private var currentMovie:Movie?

        init {
            this.currentMovie=null
            view.setOnClickListener{
                movieFoundByIdViewModel?.searchMovieById(currentMovie?.imdbID?:"null")
                parentFragmentManager?.commit {
                    replace(R.id.fragment_container_view, SecondFragment())
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
            }
        }


        fun bind(movie:Movie){
            this.currentMovie=movie
            Glide.with(imageView)
                .load(movie.poster)
                .centerCrop().placeholder(R.drawable.ic_movie).into(imageView)
            "${movie.title} (${movie.year})".also { titleAndYearTextView.text=it }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_movie,parent,false)
        val movieViewHolder = MovieViewHolder(view)
        movieViewHolder.parentFragmentManager=this.parentFragmentManager
        movieViewHolder.movieFoundByIdViewModel=this.movieFoundByIdViewModel
        return movieViewHolder
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }


    fun updateMovies(movies: List<Movie>?) {
        this.movies.clear()
        movies?.let {
            this.movies.addAll(it)
        }
        notifyDataSetChanged()
    }

}