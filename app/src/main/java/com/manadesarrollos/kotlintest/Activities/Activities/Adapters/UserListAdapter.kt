package com.manadesarrollos.kotlintest.Activities.Activities.Adapters

import Entities.User
import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import androidx.core.view.LayoutInflaterCompat
import com.manadesarrollos.kotlintest.R
import android.view.LayoutInflater
import android.widget.TextView
import android.R.attr.data




class UserListAdapter (private var userList : ArrayList<User>) : RecyclerView.Adapter<UserListAdapter.UserHolder>()
{

    companion object {

        private val TAG = "UserListAdapte"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapter.UserHolder {

        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return UserHolder(view)
    }


    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserListAdapter.UserHolder, position: Int) {
        holder.setName(userList.get(position).name)
        holder.setPass(userList.get(position).pass)
    }
    fun setData(newData: ArrayList<User>) {
        this.userList = newData
        notifyDataSetChanged()
    }


    //ViewHolder
    class UserHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //2
        private var view: View = v

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.d(TAG, "CLICK!")
        }


        fun setName (name : String) {
            val txtName : TextView = view.findViewById(R.id.txt_name_item)
            txtName.text = name
        }

        fun setPass (pass : String) {
            val txtPass : TextView = view.findViewById(R.id.txt_pass_item)
            txtPass.text = pass
        }
    }

}