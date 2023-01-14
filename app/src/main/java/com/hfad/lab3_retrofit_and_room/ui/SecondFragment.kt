package com.hfad.lab3_retrofit_and_room.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.hfad.lab3_retrofit_and_room.R
import com.hfad.lab3_retrofit_and_room.databinding.FragmentSecondBinding
import com.hfad.lab3_retrofit_and_room.model.Movie
import com.hfad.lab3_retrofit_and_room.repository.MovieRepository
import com.hfad.lab3_retrofit_and_room.ui.viewmodels.MovieFoundByIdViewModel
import com.hfad.lab3_retrofit_and_room.ui.viewmodels.MoviesViewModel
import com.hfad.lab3_retrofit_and_room.ui.viewmodels.MoviesViewModelFactory


class SecondFragment : Fragment(R.layout.fragment_second) {
    private var _binding:FragmentSecondBinding?=null
    private val binding get()=_binding!!
    private lateinit var movieFoundByIdViewModel: MovieFoundByIdViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding= FragmentSecondBinding.bind(view)

        val viewModelFactory = MoviesViewModelFactory(requireContext())
        movieFoundByIdViewModel= ViewModelProvider(requireActivity(),viewModelFactory)[MovieFoundByIdViewModel::class.java]
        movieFoundByIdViewModel.getMovieFoundByIdLiveData().observe(viewLifecycleOwner){
            it?.let {
                "MOVIE INFO:\nTitle: ${it.title}\nYear: ${it.year}\nImdbID: ${it.imdbID}\nType: ${it.type}\nPoster: \n".also {
                    binding.movieDetailsTextView.text=it
                }
                Glide.with(binding.movieImageView)
                    .load(it.poster)
                    .centerCrop().placeholder(R.drawable.ic_movie).into(binding.movieImageView)
            }

        }

    }
}