package com.example.timepass.Fragments

import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.timepass.R

class MainFragment : Fragment() {

  // Variables used to get the typing animation
  private lateinit var textView: TextView
  private val myMessage = "Know it,\nBefore you watch it."
  private val delayMillis: Long = 150 // Adjust this value to control the typing speed

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view =  inflater.inflate(R.layout.main_fragment_layout, container, false)

    // All the logic to get the typing animation
    textView = view.findViewById(R.id.tvAppMessage)
    startTypingAnimation() // Call function which will add typing animation

    // Go to the Upcoming movies fragment after clicking on Get Upcoming Movies button
    view.findViewById<Button>(R.id.btnGetUpcomingMovies).setOnClickListener {
      findNavController().navigate(R.id.action_main_Fragment_to_upcoming_Movies_Fragment)
    }

    // Go to the New Released Movies fragment after clicking on Get new released movies button
    view.findViewById<Button>(R.id.btnGetNewReleasedMovies).setOnClickListener {
      findNavController().navigate(R.id.action_main_Fragment_to_new_Released_Movie_Fragment)
    }

    // Go to the Top Rated Movies fragment after clicking on Get top rated movies button
    view.findViewById<Button>(R.id.btnTopRateddMovies).setOnClickListener {
      findNavController().navigate(R.id.action_main_Fragment_to_top_Rated_Movies_Fragment)
    }

    return view
  }

  // Function to implement the typing animation
  private fun startTypingAnimation() {
    val handler = android.os.Handler(Looper.getMainLooper())
    var currentIndex = 0
    handler.postDelayed(object : Runnable {
      override fun run() {
        if (currentIndex <= myMessage.length) {
          textView.text = myMessage.substring(0, currentIndex)
          currentIndex++
          handler.postDelayed(this, delayMillis)
        }
      }
    }, delayMillis)
  }
}