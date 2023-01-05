package com.runProject.facade.user

import com.runProject.config.DatabaseFactory.dbQuery
import com.runProject.models.user.domain.User
import com.runProject.models.user.domain.Users
import com.runProject.models.user.dto.UserRequest
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class UserDaoFacadeImpl : UserDaoFacade {
    private fun resultRowToUser(row: ResultRow) = User(
        id = row[Users.id],
        name = row[Users.name],
        email = row[Users.email],
        password = row[Users.password]
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