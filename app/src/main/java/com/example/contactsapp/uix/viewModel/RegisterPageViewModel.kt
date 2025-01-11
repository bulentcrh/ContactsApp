package com.example.contactsapp.uix.viewModel

import androidx.lifecycle.ViewModel
import com.example.contactsapp.data.repo.PersonsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterPageViewModel @Inject constructor (val pRepo : PersonsRepo) : ViewModel() {


    fun save (person_name:String, person_tel: String) {
        pRepo.save(person_name, person_tel)
    }

}