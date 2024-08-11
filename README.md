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

## Screenshots

<div align="center">
    <table>
        <tr>
            <td align="center">
                <img src="https://github.com/user-attachments/assets/66576da7-700a-47ba-ac40-9c49f8759309" alt="Splash Screen" width="200"/>
                <p><em>Splash Screen</em></p>
            </td>
            <td align="center">
                <img src="https://github.com/user-attachments/assets/08b654e6-a7a7-4697-b19c-5d98aeaffff3" alt="Main Fragment" width="200"/>
                <p><em>Main Fragment</em></p>
            </td>
            <td align="center">
                <img src="https://github.com/user-attachments/assets/f1d2f829-f26d-4ebd-b78e-05777341f61f" alt="Upcoming Movies Fragment" width="200"/>
                <p><em>Upcoming Movies Fragment</em></p>
            </td>
        </tr>
    </table>
   <table>
        <tr>
            <td align="center">
                <img src="https://github.com/user-attachments/assets/85bfce36-0312-43d7-a1a1-a89dfa0ae8e5" alt="New Released Movies Fragment" width="200"/>
                <p><em>New Released Movies Fragment</em></p>
            </td>
            <td align="center">
                <img src="https://github.com/user-attachments/assets/ba4d91a9-fa35-4692-b15a-022041529322" alt="Top Rated Movies Fragment" width="200"/>
                <p><em>Top Rated Movies Fragment</em></p>
            </td>
            <td align="center">
                <img src="https://github.com/user-attachments/assets/d3efded1-13d0-4e2b-b17f-0dd36252b8f8" alt="Details Fragment" width="200"/>
                <p><em>Details Fragment</em></p>
            </td>
           <td align="center">
                <img src="https://github.com/user-attachments/assets/0a01c49c-c215-4afe-b284-3729aed501c0" alt="Trailer Fragment" width="200"/>
                <p><em>Trailer Fragment</em></p>
            </td>
        </tr>
    </table>
</div>

   

