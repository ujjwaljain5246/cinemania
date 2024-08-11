package com.example.timepass.ViewModel

import androidx.lifecycle.ViewModel
import com.example.timepass.Constants.Utils
import com.example.timepass.DataClasses.MovieResult
import com.example.timepass.Instances.TimePassRetrofitHelper
import com.example.timepass.Interfaces.TimePassInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewReleasedMoviesViewModel : ViewModel() {

  // My api key of TMDB
  private val API_KEY:String = Utils.getApiKey()

  // Instancing the retrofit object
  val instanceRetrofitObject = TimePassRetrofitHelper.getInstanceOfRetrofit().create(TimePassInterface::class.java)

  // Fetching the movies details and putting that details in the recycler view of the upcoming_movies_fragment_layout via UpcomingMoviesRVAdapter
  fun fetchNewReleasedMovies(onResult: (List<MovieResult>?) -> Unit) {
    GlobalScope.launch {
      val result = instanceRetrofitObject.getNewReleasedMovies(API_KEY)
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