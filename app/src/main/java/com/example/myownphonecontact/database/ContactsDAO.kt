package com.example.myownphonecontact.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.concurrent.CopyOnWriteArrayList

@Dao
interface ContactsDAO {

    @Insert
    suspend fun insert(newContact: Contacts)

    @Query("SELECT * FROM contacts_table")
    fun getAllContacts(): LiveData<List<Contacts>>

    @Query("UPDATE contacts_table SET contactName =:Name, contactFamily =:Family, contactCompany =:company,contactImage=:image,contactPhone1=:phone1,contactPhone2=:phone2 WHERE contactId =:contactId")
    fun update(contactId: Long, Name:String, Family:String, company:String,image:String,phone1:String,phone2:String)
}