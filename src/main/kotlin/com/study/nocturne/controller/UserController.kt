@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.study.nocturne.controller

import com.study.nocturne.entity.User
import com.study.nocturne.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*

@RestController
class UserController(private val userService: UserService) {
    @GetMapping("/api/v1/users")
    fun findAll(
        @PageableDefault(size = 12) pageable: Pageable,
    ): Page<User> {
        return userService.findAll(pageable)
    }

    @GetMapping("/api/v1/users/{email}")
    fun findByEmail(
        @PathVariable email: String,
    ): User? {
        return userService.findByEmail(email)
    }

    @PostMapping("/api/v1/users")
    fun createUser(
        @RequestBody requestUser: User,
    ): User {
        return userService.createUser(requestUser)
    }

    @PatchMapping("/api/v1/users/{email}")
    fun updateUser(
        @PathVariable email: String,
        @RequestBody user: User,
    ): User {
        return userService.updateUser(email, user)
    }

    @PutMapping("/api/v1/users/{usernames}")
    fun updateUsers(
        @PathVariable usernames: List<String>,
        @RequestBody modifiedUsers: List<User>,
    ): List<User> {
        return userService.updateUsers(usernames, modifiedUsers)
    }

    @DeleteMapping("/api/v1/users/{username}")
    fun deleteUser(
        @PathVariable username: String,
    ): User {
        return userService.deleteUser(username)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(UserController::class.java)
    }
}
