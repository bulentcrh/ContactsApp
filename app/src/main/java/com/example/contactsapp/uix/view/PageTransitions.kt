package com.example.contactsapp.uix.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.contactsapp.data.entity.Persons
import com.example.contactsapp.uix.viewModel.DetailPageViewModel
import com.example.contactsapp.uix.viewModel.MainPageViewModel
import com.example.contactsapp.uix.viewModel.RegisterPageViewModel
import com.google.gson.Gson

@ExperimentalMaterial3Api
@Composable
fun  PageTransitions(mainPageViewModel: MainPageViewModel,
                     detailPageViewModel: DetailPageViewModel,
                     registerPageViewModel: RegisterPageViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainPage") {
        composable("mainPage") {
            MainPage(navController = navController, mainPageViewModel)
        }
        composable("userRegisterPage") {
           UserRegisterPage(registerPageViewModel, navController)
        }
        composable("userDetailPage/{person}",
            arguments = listOf(
                navArgument("person") {type = NavType.StringType }
            )
        ) {
            val json = it.arguments?.getString("person")
            val article = Gson().fromJson(json, Persons::class.java)
            UserDetailPage(article, detailPageViewModel, navController)
        }
    }
}