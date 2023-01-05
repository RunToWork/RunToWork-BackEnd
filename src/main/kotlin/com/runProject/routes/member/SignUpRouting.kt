package com.runProject.routes.member

import com.runProject.users.dto.UserRequest
import com.runProject.users.facade.dao
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.signUpRouting() {
    route("/sign-up") {
        post("/") {
            val user = call.receive<UserRequest>()
            call.respond(dao.addNewUser(user.encrpytUser())!!)
        }
    }

}