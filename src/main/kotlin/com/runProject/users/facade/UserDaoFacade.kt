package com.runProject.users.facade

import com.runProject.users.domain.User
import com.runProject.users.dto.UserRequest


interface UserDaoFacade {
    suspend fun allUsers(): List<User>
    suspend fun user(id: Int): User?
    suspend fun addNewUser(user: UserRequest): User?
    suspend fun editUser(id: Int, user: User): Boolean
    suspend fun deleteUser(id: Int): Boolean
}