package com.example.myownphonecontact.screens.allcontacts

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myownphonecontact.database.Contacts
import com.example.myownphonecontact.database.ContactsDAO
import com.example.myownphonecontact.database.ContactsDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    val viewModelScope = CoroutineScope(Dispatchers.Main)
    var contactDao: ContactsDAO
    var allContacts: LiveData<List<Contacts>>

    fun insert(contact: Contacts)= viewModelScope.launch(Dispatchers.IO) {
        contactDao.insert(contact)
    }

    init {
        contactDao = ContactsDatabase.getDatabase(application, viewModelScope).contactsDao()
        allContacts = contactDao.getAllContacts()

    }


    override fun onCleared() {
        super.onCleared()
    }
}
