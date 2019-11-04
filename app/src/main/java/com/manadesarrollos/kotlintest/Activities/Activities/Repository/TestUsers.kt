package com.manadesarrollos.kotlintest.Activities.Activities.Repository

import Entities.User

class TestUsers() {

    var userListRepository : ArrayList<User> = ArrayList()

    init {

        userListRepository.add(User("ale","123"))
        userListRepository.add(User("pepe","456"))
        userListRepository.add(User("pedro","321"))
        userListRepository.add(User("juan","444"))
        userListRepository.add(User("fede","222"))
        userListRepository.add(User("ale2","123"))
        userListRepository.add(User("pepe2","456"))
        userListRepository.add(User("pedro2","321"))
        userListRepository.add(User("juan2","444"))
        userListRepository.add(User("fede2","222"))
        userListRepository.add(User("ale3","123"))
        userListRepository.add(User("pepe3","456"))
        userListRepository.add(User("pedro3","321"))
        userListRepository.add(User("juan3","444"))
        userListRepository.add(User("fede3","222"))

    }
}
