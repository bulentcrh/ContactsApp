package com.example.contactsapp.uix.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.contactsapp.data.repo.PersonsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailPageViewModel @Inject constructor (val pRepo : PersonsRepo) : ViewModel() {
   // val pRepo = PersonsRepo()

    fun update (person_id: String, person_name:String, person_tel: String) {
        pRepo.update(person_id, person_name, person_tel)
    }
}