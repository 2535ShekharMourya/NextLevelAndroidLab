package com.azad.masterrecyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.azad.masterrecyclerview.databinding.ListItemBinding

class SimpleUserListAdapter(private val context: Context, private val userList: MutableList<String>) :
    RecyclerView.Adapter<SimpleUserListAdapter.UserViewHolder>() {

    // UserViewHolder is an inner class that holds the views for a single list item.
    // It uses View Binding to get direct references to the views in list_item_user.xml.
    inner class UserViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // The bind method takes a User object and sets the data to the corresponding views.
        fun bind(user: String) {
            binding.txtUser.text = user


            // You can also add click listeners here for individual items
            binding.root.setOnClickListener {
                // Example: Show a Toast when an item is clicked
                // The 'context' passed to the adapter can be used here.
                Toast.makeText(context, "Clicked on: ${user}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // onCreateViewHolder is called when the RecyclerView needs a new ViewHolder.
    // It inflates the item layout and creates a new UserViewHolder instance.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        // Inflate the layout using the generated binding class.
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    // onBindViewHolder is called to display data at a specified position.
    // It takes the ViewHolder and the position, then binds the data from userList.
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }

    // getItemCount returns the total number of items in the data set.
    override fun getItemCount(): Int {
        return userList.size
    }
}
