package com.manadesarrollos.kotlintest.Activities.Activities.Fragments

import Entities.User
import android.os.AsyncTask
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.findNavController

import com.manadesarrollos.kotlintest.R
import java.util.*


class UserDataFragment : Fragment()
{

    companion object
    {
        fun newInstance() = UserDataFragment()
    }

    private val TAG :String = "UserDataFragment"

    private lateinit var user : User
    private lateinit var viewModel: UserDataViewModel
    private lateinit var v :View



    private var txtCartel : TextView?= null
    private var btnCargarDatos : Button? =null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
         v =inflater.inflate(com.manadesarrollos.kotlintest.R.layout.user_data_fragment, container, false)

        txtCartel = v.findViewById(R.id.txtUserData)
        btnCargarDatos = v.findViewById(R.id.btnChangeUserData)



        return  v
    }



    override fun onStart() {
        super.onStart()


        viewModel.userData.observe(this, object : Observer<Any>
        {
            override fun onChanged(o: Any?)
            {
                txtCartel?.text = o!!.toString()
            }
        })

        btnCargarDatos?.setOnClickListener{ //  viewModel.userData.value = "fede se la come"
            v.findNavController().navigate(com.manadesarrollos.kotlintest.R.id.action_userDataFragment_to_userManagerFragment)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(UserDataViewModel::class.java)

        // TODO: Use the ViewModel

    }

}
