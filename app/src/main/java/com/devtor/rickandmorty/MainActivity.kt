package com.devtor.rickandmorty

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresExtension
import androidx.compose.material3.Surface
import com.devtor.rickandmorty.ui.RickAndMortyApp
import com.devtor.rickandmorty.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyTheme {
                Surface {
                    RickAndMortyApp()
                }
            }
        }
    }
}
