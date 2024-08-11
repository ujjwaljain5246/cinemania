package com.example.timepass.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timepass.R
import com.example.timepass.RecyclerViewAdapter.NewReleasedMovieRVAdapter
import com.example.timepass.ViewModel.NewReleasedMoviesViewModel

class NewReleasedMovieFragment : Fragment() {

  private lateinit var newReleasedMoviesViewModel: NewReleasedMoviesViewModel// ViewModel instance variable

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    // Inflate the layout for this fragment
    val view =  inflater.inflate(R.layout.list_view_layout, container, false)

    // Setting the header of the fragment
    val myHeader = view.findViewById<TextView>(R.id.tvMyHeader)
    myHeader.text = getString(R.string.new_released_movies_are)

    // Initialize the upcomingMoviesViewModel using ViewModelProvider, associating it with the current activity
    // and use UpcomingMoviesViewModel class file
    newReleasedMoviesViewModel = ViewModelProvider(this).get(NewReleasedMoviesViewModel::class.java)

    // Setting up RecyclerView
    val myRecyclerView: RecyclerView = view.findViewById(R.id.rvMyListView)
    val myLayoutManager = LinearLayoutManager(requireContext())
    myRecyclerView.layoutManager = myLayoutManager

    // Fetch upcoming movies
    newReleasedMoviesViewModel.fetchNewReleasedMovies { movies ->
      if (movies != null) {
        val adapter = NewReleasedMovieRVAdapter(movies)
        myRecyclerView.adapter = adapter
      } else {
        // Handle error case here
        Log.e(getString(R.string.TAG_NEW_RELEASED_MOVIES_FRAGMENT), getString(R.string.FAILED_RESPONSE))
      }
    }

    return view
  }

}