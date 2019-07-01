package com.example.myownphonecontact.screens.allcontacts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myownphonecontact.R
import com.example.myownphonecontact.database.Contacts

class ContactAdapter(context: Context) : RecyclerView.Adapter<ContactsViewHolder>() {
    var contactsList= emptyList<Contacts>()
    val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {

        val view = layoutInflater.inflate(R.layout.contact_item_list, parent, false)
        return ContactsViewHolder(view)
    }

    override fun getItemCount(): Int = contactsList.size

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val item = contactsList[position]
        holder.contactName.text = item.contactName
        holder.contactFamily.text = item.contactFamily
        holder.root.setOnClickListener {
            it.findNavController().
                navigate(ContactFragmentDirections.
                    actionContactFragment2ToContactDetailsFragment(item))
        }
    }
    internal fun setContact(contacts: List<Contacts>) {
        this.contactsList = contacts
        notifyDataSetChanged()
    }

}

class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val contactName: TextView = itemView.findViewById(R.id.name)
    val contactFamily: TextView = itemView.findViewById(R.id.familly)
    val root:LinearLayout = itemView.findViewById(R.id.root)
}