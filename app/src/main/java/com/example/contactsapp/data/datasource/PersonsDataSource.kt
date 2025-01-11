package com.example.contactsapp.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.contactsapp.data.entity.Persons
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PersonsDataSource(var collectionPersons : CollectionReference) {

    var personsList = MutableLiveData<List<Persons>>()

    fun save (person_name:String, person_tel: String) {
       val newPerson = Persons(person_id = "", person_name,person_tel)
       collectionPersons.document().set(newPerson)
    }


      fun update (person_id: String, person_name:String, person_tel: String) {
          var updatePerson = HashMap<String, Any>()
          updatePerson["person_id"] = person_id
          updatePerson["person_name"] = person_name
          updatePerson["person_tel"] = person_tel
          collectionPersons.document().set(updatePerson)
    }

     fun delete (person_id : String) {
         collectionPersons.document(person_id).delete()
    }


     fun uploadContacts() : MutableLiveData<List<Persons>> {
        collectionPersons.addSnapshotListener { value, error ->
            if (value != null) {
                val list = ArrayList<Persons>()

                for (d in value.documents) {
                    val persn =  d.toObject(Persons::class.java)
                    if (persn != null ) {
                        persn.person_id = d.id
                        list.add(persn)
                    }
                }
                personsList.value = list
            }
        }
        return personsList
    }

     fun search(searchKey : String) : MutableLiveData<List<Persons>> {
         collectionPersons.addSnapshotListener { value, error ->
             if (value != null) {
                 val list = ArrayList<Persons>()

                 for (d in value.documents) {
                     val persn =  d.toObject(Persons::class.java)
                     if (persn != null ) {

                         if (persn.person_name!!.lowercase().contains(searchKey.lowercase()) ){

                             persn.person_id = d.id
                             list.add(persn)
                         }
                     }
                 }
                 personsList.value = list
             }
         }
        return personsList
    }


}