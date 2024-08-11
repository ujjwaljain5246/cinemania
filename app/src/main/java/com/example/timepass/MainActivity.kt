package com.example.timepass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.main_activity_layout)

    // Finding the NavHostFragment using its ID and casting it to NavHostFragment type.
    val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment

    // Retrieving the NavController associated with the NavHostFragment.
    val navController = navHostFragment.navController

    // Set up the ActionBar with the NavController
    setupActionBarWithNavController(navController)
  }

  // Function to go back to the list fragment after pressing back arrow in navigation bar
  override fun onSupportNavigateUp(): Boolean {
    val navController = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container)!!.findNavController()
    return navController.navigateUp() || super.onSupportNavigateUp()
  }

}

