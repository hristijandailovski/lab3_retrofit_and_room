package com.hfad.lab3_retrofit_and_room.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.hfad.lab3_retrofit_and_room.R
import com.hfad.lab3_retrofit_and_room.adapters.MovieAdapter
import com.hfad.lab3_retrofit_and_room.databinding.FragmentFirstBinding
import com.hfad.lab3_retrofit_and_room.ui.viewmodels.MovieFoundByIdViewModel
import com.hfad.lab3_retrofit_and_room.ui.viewmodels.MoviesViewModel
import com.hfad.lab3_retrofit_and_room.ui.viewmodels.MoviesViewModelFactory


class FirstFragment : Fragment(R.layout.fragment_first) {

    private var _binding:FragmentFirstBinding? =null
    private val binding get() = _binding!!
    private lateinit var moviesViewModel:MoviesViewModel
    private lateinit var movieFoundByIdViewModel: MovieFoundByIdViewModel



    override fun onViewCreated(view:View, savedInstanceState:Bundle?){
        super.onViewCreated(view, savedInstanceState)
        _binding=FragmentFirstBinding.bind(view)

        val viewModelFactory = MoviesViewModelFactory(requireContext())
        moviesViewModel = ViewModelProvider(this,viewModelFactory)[MoviesViewModel::class.java]
        movieFoundByIdViewModel=ViewModelProvider(requireActivity(),viewModelFactory)[MovieFoundByIdViewModel::class.java]

        val adapter = MovieAdapter(parentFragmentManager=parentFragmentManager, movieFoundByIdViewModel = movieFoundByIdViewModel)
        binding.movieList.adapter= adapter

        moviesViewModel.getMovieLiveData().observe(viewLifecycleOwner){
            adapter.updateMovies(it)
        }
        binding.searchButton.setOnClickListener {
            val query = binding.queryEditText.text.toString()
            if (query.isEmpty()) {
                Snackbar.make(view,R.string.please_enter_query, Snackbar.LENGTH_LONG).show()
            } else {
                moviesViewModel.search(query)
            }
        }
        moviesViewModel.listAll()

    }


}