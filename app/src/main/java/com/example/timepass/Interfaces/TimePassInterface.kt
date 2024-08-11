package com.example.timepass.Interfaces

import com.example.timepass.DataClasses.MovieResponse
import com.example.timepass.DataClasses.TrailerResponse
import com.example.timepass.DataClasses.TrailerResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TimePassInterface {

  // Define the endpoint for fetching data of upcoming movie
  @GET("upcoming")
  suspend fun getUpcomingMovies(@Query("api_key") apiKey: String): Response<MovieResponse>

  // Define the endpoint for fetching data of new released movie
  @GET("now_playing")
  suspend fun getNewReleasedMovies(@Query("api_key") apiKey: String): Response<MovieResponse>

  // Define the endpoint for fetching data of new released movie
  @GET("top_rated")
  suspend fun getTopRatedMovies(@Query("api_key") apiKey: String): Response<MovieResponse>

  // Get the trailer
  @GET("{movie_id}/videos")
  suspend fun getMovieTrailer(
    @Path("movie_id") movieId: String,
    @Query("api_key") apiKey: String
  ): Response<TrailerResponse>

}