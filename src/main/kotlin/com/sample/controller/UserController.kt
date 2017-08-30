package com.sample.controller

import com.sample.entity.User
import com.sample.service.UserService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/users")
class UserController(
        private val userService: UserService
) {
    @RequestMapping("/{id}")
    fun getUser(
            @PathVariable id: Long
    ): User {
        return userService.getUser(id)
    }
}