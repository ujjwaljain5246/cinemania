package com.example.timepass.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timepass.R
import com.example.timepass.RecyclerViewAdapter.TopRatedMovieRVAdapter
import com.example.timepass.ViewModel.TopRatedMoviesViewModel

class TopRatedMoviesFragment : Fragment() {

  private lateinit var topRatedMoviesViewModel: TopRatedMoviesViewModel // ViewModel instance variable

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view =  inflater.inflate(R.layout.list_view_layout, container, false)

    // Setting the header for the fragment
    val myHeader = view.findViewById<TextView>(R.id.tvMyHeader)
    myHeader.text = getString(R.string.top_rated_movies_are)

    // Initialize the topRatedMoviesViewModel using ViewModelProvider, associating it with the current activity
    // and use TopRatedMoviesViewModel class file
    topRatedMoviesViewModel = ViewModelProvider(this).get(TopRatedMoviesViewModel::class.java)

    // Setting up RecyclerView
    val myRecyclerView: RecyclerView = view.findViewById(R.id.rvMyListView)
    val myLayoutManager = LinearLayoutManager(requireContext())
    myRecyclerView.layoutManager = myLayoutManager

    // Fetch upcoming movies
    topRatedMoviesViewModel.fetchTopRatedMovies { movies ->
      if (movies != null) {
        val adapter = TopRatedMovieRVAdapter(movies)
        myRecyclerView.adapter = adapter
      } else {
        // Handle error case here
        Log.e(getString(R.string.TAG_TOP_RATED_MOVIES_FRAGMENT), getString(R.string.FAILED_RESPONSE))
      }
    }

    return view
  }

}