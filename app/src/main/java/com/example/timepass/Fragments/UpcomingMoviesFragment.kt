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
import com.example.timepass.RecyclerViewAdapter.UpcomingMoviesRVAdapter
import com.example.timepass.ViewModel.UpcomingMoviesViewModel

class UpcomingMoviesFragment : Fragment() {

  private lateinit var upcomingMoviesViewModel: UpcomingMoviesViewModel // ViewModel instance variable

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    // Inflate the layout for this fragment
    val view =  inflater.inflate(R.layout.list_view_layout, container, false)

    // Setting the header for the fragment
    val myHeader = view.findViewById<TextView>(R.id.tvMyHeader)
    myHeader.text = getString(R.string.upcoming_movies_are)

    // Initialize the upcomingMoviesViewModel using ViewModelProvider, associating it with the current activity
    // and use UpcomingMoviesViewModel class file
    upcomingMoviesViewModel = ViewModelProvider(this).get(UpcomingMoviesViewModel::class.java)

    // Setting up RecyclerView
    val myRecyclerView: RecyclerView = view.findViewById(R.id.rvMyListView)
    val myLayoutManager = LinearLayoutManager(requireContext())
    myRecyclerView.layoutManager = myLayoutManager

    // Fetch upcoming movies
    upcomingMoviesViewModel.fetchUpcomingMovies { movies ->
      if (movies != null) {
        val adapter = UpcomingMoviesRVAdapter(movies)
        myRecyclerView.adapter = adapter
      } else {
        // Handle error case here
        Log.e(getString(R.string.TAG_UPCOMING_MOVIES_FRAGMENT), getString(R.string.TAG_UPCOMING_MOVIES_FRAGMENT))
      }
    }

    return view
  }

}