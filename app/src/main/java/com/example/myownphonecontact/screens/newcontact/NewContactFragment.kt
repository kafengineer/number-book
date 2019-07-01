package com.example.myownphonecontact.screens.newcontact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myownphonecontact.R
import com.example.myownphonecontact.databinding.FragmentNewContactBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_new_contact.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.myownphonecontact.database.Contacts
import com.example.myownphonecontact.screens.allcontacts.ContactViewModel


class NewContactFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentNewContactBinding>(
            inflater,
            R.layout.fragment_new_contact, container, false
        )
        val newContactViewModel = ViewModelProviders.of(this).get(NewContactViewModel::class.java)



        binding.saveButton.setOnClickListener {
            val contacts = Contacts(
                contactName = binding.name.text.toString(),
                contactFamily = binding.family.text.toString(),
                contactCompany = binding.company.text.toString(),
                contactImage = "",
                contactPhone1 = binding.phone1.text.toString(),
                contactPhone2 = binding.phone2.text.toString()
            )
            newContactViewModel.insert(contacts)
            it.findNavController().navigate(NewContactFragmentDirections.actionNewContactFragmentToContactFragment2())
        }
        return binding.root
    }
}
