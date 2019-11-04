package com.manadesarrollos.kotlintest.Activities.Activities.Fragments

import Entities.User
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.manadesarrollos.kotlintest.Activities.Activities.Adapters.UserListAdapter
import com.manadesarrollos.kotlintest.Activities.Activities.Repository.TestUsers

import com.manadesarrollos.kotlintest.R



class UserListFragment : Fragment()
{
    lateinit var recyclerView : RecyclerView
    lateinit var btnAdd :FloatingActionButton

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var userListAdapter: UserListAdapter
    private  var testUsers : TestUsers = TestUsers()

    private lateinit var listViewModel: UserListViewModel

    companion object {
        fun newInstance() = UserListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v :View

        v = inflater.inflate(R.layout.user_list_fragment, container, false)
        recyclerView = v.findViewById(R.id.user_recycler)
        btnAdd = v.findViewById(R.id.btn_add)

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listViewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)
    }

    override fun onStart()
    {
        super.onStart()
        linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.setHasFixedSize(true)

        listViewModel.setUserList(testUsers.userListRepository)

        userListAdapter = UserListAdapter(listViewModel.getUserList())
        recyclerView.adapter = userListAdapter

        listViewModel.userList?.observe(this, Observer{ users -> userListAdapter.setData(users) })

        btnAdd.setOnClickListener {
            // var list : ArrayList<User> =  listViewModel.getUserList()
            listViewModel.getUserList().add(User("new","new"))
            listViewModel.setUserList(listViewModel.getUserList())
        }




    }
}
