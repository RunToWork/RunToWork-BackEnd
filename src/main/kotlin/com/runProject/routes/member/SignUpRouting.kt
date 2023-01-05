package com.runProject.routes.member

import com.runProject.models.user.dto.UserRequest
import com.runProject.facade.user.dao
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