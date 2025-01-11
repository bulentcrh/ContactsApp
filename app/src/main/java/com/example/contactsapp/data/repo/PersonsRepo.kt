package com.example.contactsapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.contactsapp.data.datasource.PersonsDataSource
import com.example.contactsapp.data.entity.Persons

class PersonsRepo(var pds : PersonsDataSource) {

     fun save (person_name:String, person_tel: String) = pds.save(person_name,person_tel)

     fun update (person_id: String, person_name:String, person_tel: String) = pds.update(person_id,person_name, person_tel)

     fun delete (person_id : String) = pds.delete(person_id)

     fun uploadContacts() : MutableLiveData<List<Persons>> = pds.uploadContacts()

     fun search(searchKey : String) : MutableLiveData<List<Persons>> = pds.search(searchKey)


    




}
