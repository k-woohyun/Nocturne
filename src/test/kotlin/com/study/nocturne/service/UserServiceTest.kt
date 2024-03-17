package com.study.nocturne.service

import com.study.nocturne.entity.User
import com.study.nocturne.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest {
    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun getusers() {
    }

    @Test
    fun setusers() {
    }

    @Test
    fun findByAll() {
        var users: List<User> = userRepository.findAll()
        println("user ::: " + users)
    }
}
