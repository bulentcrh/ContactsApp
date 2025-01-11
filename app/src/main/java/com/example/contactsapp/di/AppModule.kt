package com.example.contactsapp.di

import com.example.contactsapp.data.datasource.PersonsDataSource
import com.example.contactsapp.data.entity.Persons
import com.example.contactsapp.data.repo.PersonsRepo
import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule() {

    @Provides
    @Singleton
    fun providePersonsRepo(pds : PersonsDataSource) : PersonsRepo {
        return  PersonsRepo(pds)
    }


    @Provides
    @Singleton
    fun providePersonsDataSource(collectionPersons: CollectionReference ) : PersonsDataSource {
            return  PersonsDataSource(collectionPersons)
    }

    @Provides
    @Singleton
    fun provideCollectionReference() : CollectionReference {
        return Firebase.firestore.collection("Persons")
    }
}