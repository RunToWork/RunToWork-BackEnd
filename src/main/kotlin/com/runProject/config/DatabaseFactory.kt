package com.runProject.config

import com.runProject.models.user.domain.Users
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init() {
        val url = "jdbc:mariadb://127.0.0.1:3306/RC?useUnicode=true&serverTimezone=Asia/Seoul"
        val driver = "org.mariadb.jdbc.Driver"
        val user = "root"
        val password = "1104"
        val database = Database.connect(url, driver, user, password)

        transaction(database) {
            SchemaUtils.create(Users)
        }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}