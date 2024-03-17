package com.study.springbootjpa.repository

import com.study.springbootjpa.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?

    fun findByUsername(userName: String): User?

    fun existsByUsername(username: String): Boolean
}
