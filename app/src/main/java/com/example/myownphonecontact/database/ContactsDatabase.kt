package com.example.myownphonecontact.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Contacts::class], version = 4)
abstract class ContactsDatabase : RoomDatabase() {
    abstract fun contactsDao(): ContactsDAO

    //Singleton to avoid variant instances of the bank of dice
    companion object {
        @Volatile
        private var INSTANCE: ContactsDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ContactsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactsDatabase::class.java,
                    "contacts_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }

    }
}