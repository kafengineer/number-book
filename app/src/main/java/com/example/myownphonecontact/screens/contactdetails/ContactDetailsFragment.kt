package com.example.myownphonecontact.screens.contactdetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myownphonecontact.R
import com.example.myownphonecontact.databinding.ContactDetailsFragmentBinding

class ContactDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ):
            View? {
        val binding = DataBindingUtil.inflate<ContactDetailsFragmentBinding>(
            inflater,
            R.layout.contact_details_fragment, container, false
        )
        setHasOptionsMenu(true)

        var args = arguments?.let { ContactDetailsFragmentArgs.fromBundle(it) }
        if (args != null) {
            binding.NameFamily.text = args.contact.contactName + args.contact.contactFamily
            binding.phone1.text = args.contact.contactPhone1
            binding.phone2.text = args.contact.contactPhone2

        }

        binding.messageButton.setOnClickListener {
            // composeMmsMessage("hi")
        }
        return binding.root
    }

    fun composeMmsMessage(message: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            data = Uri.parse("smsto:")  // This ensures only SMS apps respond
            putExtra("sms_body", message)
        }
        startActivity(intent)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_edit, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.ContactEdit -> gotoEdit()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun gotoEdit() {
        var args = arguments?.let { ContactDetailsFragmentArgs.fromBundle(it) }
        findNavController().navigate(
            ContactDetailsFragmentDirections
                .actionContactDetailsFragmentToContactEdit(args!!.contact)
        )
    }
}