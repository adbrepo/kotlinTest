package com.manadesarrollos.kotlintest.Activities.Activities.Fragments

import Entities.User
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserListViewModel : ViewModel()
{

    var  userList : MutableLiveData<ArrayList<User>>?

    init {
        userList = MutableLiveData<ArrayList<User>>()
    }

    fun getUserList(): ArrayList<User>{
        return userList?.value!!
    }

    fun setUserList(list : ArrayList<User>){
        userList?.value = list
    }



}
