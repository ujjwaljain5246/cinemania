package com.example.timepass.RecyclerViewAdapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.timepass.Constants.Utils
import com.example.timepass.DataClasses.MovieResult
import com.example.timepass.R
import com.example.timepass.Fragments.UpcomingMoviesFragmentDirections

class UpcomingMoviesRVAdapter(val myMovies:List<MovieResult>): RecyclerView.Adapter<UpcomingMoviesRVAdapter.UpcomingMoviesRVViewHolder>() {

  // BASE URL to get the image or poster of the movie. We will add the poster_path to this URL to get the complete link of the movie poster
  val BASE_URL_IMAGE = Utils.getBaseUrlImage()

  class UpcomingMoviesRVViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val myImageView = itemView.findViewById<ImageView>(R.id.ivMoviePoster)
    val myMovieName = itemView.findViewById<TextView>(R.id.tvMovieName)
    val myMovieDescription = itemView.findViewById<TextView>(R.id.tvMovieDescription)
    val myCLForEachMovie = itemView.findViewById<ConstraintLayout>(R.id.clForEachMovie)
  }

  // Binding the views of the single item via single_item_layout
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMoviesRVViewHolder {
    return UpcomingMoviesRVViewHolder(
      LayoutInflater.from(parent.context).inflate(
        R.layout.single_item_layout,
        parent,
        false
      ))
  }

  // Binding the data to the single_item_layout
  override fun onBindViewHolder(holder: UpcomingMoviesRVViewHolder, position: Int) {

    val currentMovie = myMovies[position]

    // Set the Image
    Log.d("Movie image", "Image url is: ${BASE_URL_IMAGE + currentMovie.poster_path }")
    Glide.with(holder.itemView)
      .load(BASE_URL_IMAGE + currentMovie.poster_path)
      .into(holder.myImageView)

    // Set the movie name
    Log.d("Movie name", currentMovie.title)
    holder.myMovieName.text = currentMovie.title

    // Set the movie description
    Log.d("Movie description", currentMovie.overview)
    holder.myMovieDescription.text = currentMovie.overview

    // Navigation to the Details fragment from Upcoming movies fragment and passing the details of the movie which is clicked to Details fragment
    holder.myCLForEachMovie.setOnClickListener {
      val action = UpcomingMoviesFragmentDirections.actionUpcomingMoviesFragmentToDetailsFragment(currentMovie)
      holder.itemView.findNavController().navigate(action)
    }
  }

  // Return the size of the myMovies
  override fun getItemCount(): Int {
    return myMovies.size
  }
}