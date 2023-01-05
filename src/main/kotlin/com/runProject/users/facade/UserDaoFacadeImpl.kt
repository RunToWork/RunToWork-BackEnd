package com.runProject.users.facade

import com.runProject.config.DatabaseFactory.dbQuery
import com.runProject.users.domain.User
import com.runProject.users.domain.Users
import com.runProject.users.dto.UserRequest
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class UserDaoFacadeImpl : UserDaoFacade {
    private fun resultRowToUser(row: ResultRow) = User(
        id = row[Users.id],
        name = row[Users.name],
        email = row[Users.email],
        password = row[Users.password],
        mobileNumber = row[Users.mobileNumber]
    )

    override suspend fun allUsers(): List<User> {
        TODO("Not yet implemented")
    }

    override suspend fun user(id: Int): User? {
        TODO("Not yet implemented")
    }

    override suspend fun addNewUser(request: UserRequest): User? = dbQuery {
        val insertStatement = Users.insert {
            it[name] = request.name
            it[email] = request.email
            it[password] = request.password
            it[mobileNumber] = request.mobileNumber
        }

        transaction {
            insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToUser)
        }

    }

    override suspend fun editUser(id: Int, user: User): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}

val dao: UserDaoFacade = UserDaoFacadeImpl()