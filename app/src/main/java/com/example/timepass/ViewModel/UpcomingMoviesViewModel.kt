package com.example.timepass.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timepass.Constants.Utils
import com.example.timepass.DataClasses.MovieResponse
import com.example.timepass.DataClasses.MovieResult
import com.example.timepass.Instances.TimePassRetrofitHelper
import com.example.timepass.Interfaces.TimePassInterface
import com.example.timepass.R
import com.example.timepass.RecyclerViewAdapter.UpcomingMoviesRVAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UpcomingMoviesViewModel :ViewModel() {

  // My api key of TMDB
  private val API_KEY:String = Utils.getApiKey()

  // Instancing the retrofit object
  val instanceRetrofitObject = TimePassRetrofitHelper.getInstanceOfRetrofit().create(TimePassInterface::class.java)

  // Fetching the movies details and putting that details in the recycler view of the upcoming_movies_fragment_layout via UpcomingMoviesRVAdapter
  fun fetchUpcomingMovies(onResult: (List<MovieResult>?) -> Unit) {
    GlobalScope.launch {
      val result = instanceRetrofitObject.getUpcomingMovies(API_KEY)
      if (result.isSuccessful) {
        val ourMoviesList = result.body()
        withContext(Dispatchers.Main) {
          onResult(ourMoviesList?.results)
        }
      } else {
        withContext(Dispatchers.Main) {
          onResult(null)
        }
      }
    }
  }

}