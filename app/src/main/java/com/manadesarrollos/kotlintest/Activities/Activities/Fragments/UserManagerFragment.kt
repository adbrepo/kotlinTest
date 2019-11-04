package com.manadesarrollos.kotlintest.Activities.Activities.Fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.manadesarrollos.kotlintest.R

class UserManagerFragment : Fragment() {

    companion object {
        fun newInstance() = UserManagerFragment()
    }

    private lateinit var viewModelManager: UserManagerViewModel
    private lateinit var viewModelData: UserDataViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_manager_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelManager = ViewModelProviders.of(this).get(UserManagerViewModel::class.java)
        viewModelData = ViewModelProviders.of(requireActivity()).get(UserDataViewModel::class.java)


        // TODO: Use the ViewModel
    }



    override fun onStart() {
        super.onStart()
        viewModelData.userData.value="otro dato loco!"


    }
}




