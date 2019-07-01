package com.example.myownphonecontact.screens.contactedit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myownphonecontact.R
import com.example.myownphonecontact.databinding.ContactEditFragmentBinding

class ContactEdit : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val bindingg= DataBindingUtil.inflate<ContactEditFragmentBinding>(inflater,R.layout.contact_edit_fragment,container,false)
        setHasOptionsMenu(true)

        var args = ContactEditArgs.fromBundle(arguments!!)

        bindingg.name.setText(args.toBeEditedContact.contactName)
        bindingg.family.setText(args.toBeEditedContact.contactFamily)
        bindingg.company.setText(args.toBeEditedContact.contactCompany)
        bindingg.phone1.setText(args.toBeEditedContact.contactPhone1)
        bindingg.phone2.setText(args.toBeEditedContact.contactPhone2)

        bindingg.saveButton.setOnClickListener {

        }
        return bindingg.root
    }

}