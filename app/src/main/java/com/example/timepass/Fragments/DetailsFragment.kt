package com.example.timepass.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.timepass.Constants.Utils
import com.example.timepass.R

class DetailsFragment : Fragment() {

  // BASE URL of the TMDB api for the movie poster. We will add the poster_path to get complete URL and then we will fetch the movie poster from that URL
  val BASE_URL_IMAGE = Utils.getBaseUrlImage()

  // Accepting the argument passed by the previous fragments so that all the details of that movie can be displayed
  private val args by navArgs<DetailsFragmentArgs>()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view =  inflater.inflate(R.layout.details_fragment_layout, container, false)

    // Set the movie poster
    Log.d("Movie image", "Image url is: ${BASE_URL_IMAGE + args.CurrentMovie.poster_path }")
    Glide.with(view)
      .load(BASE_URL_IMAGE + args.CurrentMovie.poster_path)
      .into(view.findViewById(R.id.ivMoviePoster))

    // Set the movie name
    view.findViewById<TextView>(R.id.tvMovieName).setText(args.CurrentMovie.title)

    // Set the movie category
    if (args.CurrentMovie.adult){
      view.findViewById<TextView>(R.id.tvMovieCategory).text = getString(R.string.adult)
    } else {
      view.findViewById<TextView>(R.id.tvMovieCategory).text = getString(R.string.under_18)
    }

    // Set the movie release date
    view.findViewById<TextView>(R.id.tvMovieReleaseDate).setText(args.CurrentMovie.release_date)

    // Set the movie description
    view.findViewById<TextView>(R.id.tvMovieDescription).setText(args.CurrentMovie.overview)

    // Navigate to the trailer fragment from detail fragment after clicking on the watch trailer button
    view.findViewById<Button>(R.id.btnWathcTrailer).setOnClickListener {
      val action = DetailsFragmentDirections.actionDetailsFragmentToTrailerPlayerFragment(args.CurrentMovie)
      findNavController().navigate(action)
    }

    return view
  }

}