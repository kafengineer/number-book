package com.example.myownphonecontact.screens.newcontact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myownphonecontact.database.Contacts
import com.example.myownphonecontact.database.ContactsDAO
import com.example.myownphonecontact.database.ContactsDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewContactViewModel(application: Application) :AndroidViewModel( application){

    val viewModelScope = CoroutineScope(Dispatchers.Main)
    var contactDao: ContactsDAO
    init {
        contactDao = ContactsDatabase.getDatabase(application, viewModelScope).contactsDao()
    }
    fun insert(contact: Contacts)= viewModelScope.launch(Dispatchers.IO) {
        contactDao.insert(contact)
    }
}