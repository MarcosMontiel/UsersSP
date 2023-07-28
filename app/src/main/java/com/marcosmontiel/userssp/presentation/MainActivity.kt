package com.marcosmontiel.userssp.presentation

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.marcosmontiel.userssp.presentation.navigation.RootNavGraph
import com.marcosmontiel.userssp.presentation.ui.theme.UsersSPTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var _preferences: SharedPreferences
    private lateinit var _navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            UsersSPTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    _preferences = getPreferences(Context.MODE_PRIVATE)
                    _navController = rememberNavController()

                    RootNavGraph(navController = _navController, preferences = _preferences)

                }
            }
        }

    }

}