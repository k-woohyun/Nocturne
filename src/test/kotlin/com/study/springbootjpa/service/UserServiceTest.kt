package com.study.springbootjpa.service

import com.study.springbootjpa.entity.User
import com.study.springbootjpa.repository.UserRepository
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
