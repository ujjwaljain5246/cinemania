package com.example.timepass.Instances

import com.example.timepass.Constants.Utils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TimePassRetrofitHelper {

  // BASE URL of the TMDB api. We will change the endpoint like now_playing, upcoming, top_rated, popular
  private val BASE_URL:String = Utils.getBaseUrl()

  // Function to make the complete URL i.e. appending the apikey to the base URL
  fun getInstanceOfRetrofit(): Retrofit {
    return Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

}