package com.example.timepass.Constants

open class Utils {

  companion object {
    private const val API_KEY = "YOUR_TMDB_API_KEY" // For example "8f4e7c6b5a1e2d3c4f7b9e1d2c8a7b6d"
    private const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w500/"
    private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

    fun getApiKey() : String {
      return API_KEY
    }

    fun getBaseUrlImage() : String {
      return BASE_URL_IMAGE
    }

    fun getBaseUrl() : String {
      return BASE_URL
    }

  }

}