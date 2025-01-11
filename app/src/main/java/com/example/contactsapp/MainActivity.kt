package com.example.contactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.contactsapp.ui.theme.ContactsAppTheme
import com.example.contactsapp.uix.view.PageTransitions
import com.example.contactsapp.uix.viewModel.DetailPageViewModel
import com.example.contactsapp.uix.viewModel.MainPageViewModel
import com.example.contactsapp.uix.viewModel.RegisterPageViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val mainPageViewModel : MainPageViewModel by viewModels()
    val detailPageViewModel : DetailPageViewModel by viewModels()
    val registerPageViewModel : RegisterPageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsAppTheme {
                PageTransitions(mainPageViewModel, detailPageViewModel, registerPageViewModel)
            }
        }
    }
}

