package com.example.timepass.ViewModel

import android.util.Log
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.example.timepass.Constants.Utils
import com.example.timepass.Instances.TimePassRetrofitHelper
import com.example.timepass.Interfaces.TimePassInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TrailerPlayerViewModel : ViewModel() {

  // My api key of TMDB
  private val API_KEY:String = Utils.getApiKey()

  // Instancing the retrofit object
  val instanceRetrofitObject = TimePassRetrofitHelper.getInstanceOfRetrofit().create(TimePassInterface::class.java)

  // Variable to store trailer key
  private var trailerCode: String? = null

  fun fetchTrailerCode(movieID:String, onResult: (String) -> Unit){
    // We are launching the trailer using scope
    GlobalScope.launch(Dispatchers.Main) {
      val result = instanceRetrofitObject.getMovieTrailer(movieID, API_KEY)
      if (result.isSuccessful) {
        val ourTrailer = result.body()
        Log.i("ourTrailer", ourTrailer.toString())
        if (ourTrailer != null) {
          for (i in 0..<ourTrailer.results.size) {
            if (ourTrailer.results[i].type == "Trailer") {
              trailerCode = ourTrailer.results[i].key
              onResult(trailerCode!!)
              break
            }
          }
        } else {
          Log.e("TrailerPlayerViewModel", "Response body is null")
        }
      } else {
        Log.e("TrailerPlayerViewModel", "Failed to fetch data: ${result.code()}")
      }
    }
  }
}