package com.example.myownphonecontact.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "contacts_table")
data class Contacts  (
    @PrimaryKey(autoGenerate = true)
    var contactId:Int?= null,

    var contactName :String="",
    var contactFamily:String="",
    var contactCompany:String="",
    var contactImage:String="",
    var contactPhone1:String="",
    var contactPhone2:String=""):Parcelable