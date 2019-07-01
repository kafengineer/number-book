package com.example.myownphonecontact.screens.allcontacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myownphonecontact.R
import com.example.myownphonecontact.database.Contacts
import com.example.myownphonecontact.databinding.ContactFragmentBinding
import kotlinx.android.synthetic.main.contact_fragment.view.*

class ContactFragment :Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<ContactFragmentBinding>(inflater,
            R.layout.contact_fragment,container,false)
        val contactViewModel = ViewModelProviders.of(this).get(ContactViewModel::class.java)


        val contactListManager= LinearLayoutManager(activity)
        val adapter = ContactAdapter(this.context!!)
        binding.contactList.layoutManager= contactListManager
        binding.contactList.adapter = adapter

        contactViewModel.allContacts.observe(this, Observer { contacts ->
            contacts.let { adapter.setContact(it) }
        })

        binding.addFloatingButton.setOnClickListener {
            it.findNavController().navigate(ContactFragmentDirections.actionContactFragment2ToNewContactFragment())
            /*val contacts = Contacts(contactName = "ali",contactFamily = "safiyari")
            contactViewModel.insert(contacts)*/
        }
        return binding.root
    }
}