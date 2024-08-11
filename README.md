# Cinemania App

This is an Android application that helps users discover the latest releases, upcoming films, and top-rated movies. Users can view trailers before purchasing tickets, ensuring they make the best choice for their movie experience.

## Features

- **Latest Releases**: Stay up-to-date with the most recent movie releases.
- **Upcoming Films**: Get information on movies that are soon to be released.
- **Top-Rated Movies**: Explore highly rated movies and decide what to watch next.
- **Watch Trailers**: Preview trailers before buying tickets to ensure it's the right movie for you.

## Tech Stack

- **Language**: Kotlin
- **UI Design**: XML
- **Architecture**: MVVM (Model-View-ViewModel)
- **Navigation**: NavigationGraph
- **UI Components**: Fragments, RecyclerView
- **Networking**: Retrofit
- **Media Player**: YouTube Video Player
- **Data Source**: TMDB (The Movie Database) API

## App Structure

- **Single Activity Architecture**: The app uses only one Activity, with different screens represented as Fragments.
- **Fragment Navigation**: Navigation between Fragments is managed through NavigationGraph, making use of `navArguments` to pass data between Fragments.
- **ViewModel**: Each Fragment is paired with its own ViewModel to handle data and UI logic, following the MVVM architecture.

## API Integration
The app integrates with TMDB (The Movie Database) API to fetch movie data, including details like latest releases, upcoming films, and top-rated movies.

## How to Run the Projet
1. Clone the repository
2. Open the project in Android Studio.
3. Sync the project with Gradle files.
4. Add you TMDB API Key in Utils class.
5. Build and run the project on an emulator or physical device.
   

