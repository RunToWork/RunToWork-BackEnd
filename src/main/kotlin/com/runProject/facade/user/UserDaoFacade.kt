package com.runProject.facade.user

import com.runProject.models.user.domain.User
import com.runProject.models.user.dto.UserRequest

interface UserDaoFacade {
    suspend fun allUsers(): List<User>
    suspend fun user(id: Int): User?
    suspend fun addNewUser(user: UserRequest): User?
    suspend fun editUser(id: Int, user: User): Boolean
    suspend fun deleteUser(id: Int): Boolean
}