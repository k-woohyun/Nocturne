package com.study.nocturne.repository

import com.study.nocturne.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?

    fun findByUsername(userName: String): User?

    fun existsByUsername(username: String): Boolean
}
