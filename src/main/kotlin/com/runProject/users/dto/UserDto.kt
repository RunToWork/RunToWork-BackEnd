package com.runProject.users.dto

import kotlinx.serialization.Serializable
import org.mindrot.jbcrypt.BCrypt

@Serializable
data class UserRequest(
    val name: String,
    val email: String,
    val password: String,
    val mobileNumber: String
) {
    fun encrpytUser() = UserRequest(
        name = this.name,
        email = this.email,
        password = BCrypt.hashpw(this.password,BCrypt.gensalt(12)),
        mobileNumber = this.mobileNumber
    )
}