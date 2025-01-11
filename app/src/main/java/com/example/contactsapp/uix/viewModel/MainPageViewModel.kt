package com.example.contactsapp.uix.viewModel

import android.app.Person
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactsapp.data.entity.Persons
import com.example.contactsapp.data.repo.PersonsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor (var pRepo : PersonsRepo) : ViewModel() {

   var personsList = MutableLiveData<List<Persons>>()

    init {
        uploadContacts()
    }


    fun delete (person_id : String) {
        pRepo.delete(person_id)
    }

     fun uploadContacts() {
         personsList = pRepo.uploadContacts()
     }

    fun search(searchKey : String) {
        personsList = pRepo.search(searchKey)
    }


}