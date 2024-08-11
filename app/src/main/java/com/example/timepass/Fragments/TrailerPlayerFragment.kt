package com.example.timepass.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.timepass.R
import com.example.timepass.ViewModel.TrailerPlayerViewModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class TrailerPlayerFragment : Fragment() {

  // Accepting the argument passed by the previous fragments so that all the details of that movie will be available to search trailer
  private val args by navArgs<TrailerPlayerFragmentArgs>()

  // Initializing YouTubePlayerView
  private lateinit var myTrailerPlayView: YouTubePlayerView

  private lateinit var trailerPlayerViewModel: TrailerPlayerViewModel // ViewModel instance variable

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.trailer_player_fragment_layout, container, false)

    // To access the myPlayerView in the private function
    myTrailerPlayView = view.findViewById(R.id.ytpvTrailerPlayer)

    // To check whether we are getting the movie ID or not
    val movieID = args.MovieDetails.id.toString()
    Log.i("MovieID", movieID)

    // Initialize the upcomingMoviesViewModel using ViewModelProvider, associating it with the current activity
    // and use UpcomingMoviesViewModel class file
    trailerPlayerViewModel = ViewModelProvider(this).get(TrailerPlayerViewModel::class.java)

    // We are launching the trailer using scope
    trailerPlayerViewModel.fetchTrailerCode(movieID){
      startTrailerPlayer(it)
    }

    return view
  }

  private fun startTrailerPlayer(trailerCode: String) {
    // Create MediaItem to add URL to the exoPlayer
    myTrailerPlayView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
      override fun onReady(youTubePlayer: YouTubePlayer) {
        super.onReady(youTubePlayer)
        youTubePlayer.loadVideo(trailerCode, 0F)
      }
    })
  }
}