package com.runProject.users.domain

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class User(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val mobileNumber: String
)

object Users: Table(){
    val id = integer("id").autoIncrement()
    val name = varchar("name", 255)
    val email = varchar("email", 255)
    val password = varchar("password", 255)
    val mobileNumber = varchar("mobile_number", 255)

    override val primaryKey = PrimaryKey(id)
}