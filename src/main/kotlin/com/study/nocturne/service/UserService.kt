package com.study.nocturne.service

import com.study.nocturne.entity.Status
import com.study.nocturne.entity.User
import com.study.nocturne.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class UserService(private val userRepository: UserRepository) {
    fun findAll(pageable: Pageable): Page<User> {
        return userRepository.findAll(pageable)
    }

    fun findByEmail(email: String): User? {
        return userRepository.findByEmail(email) ?: throw NullPointerException("찾으시는 회원 정보가 없습니다.")
    }

    @Transactional
    fun createUser(user: User): User {
        val checkUser = userRepository.existsByUsername(user.username)
        return if (checkUser) {
            throw Exception("이미 등록된 회원 정보 입니다.")
        } else {
            userRepository.save(user)
        }
    }

    @Transactional
    fun updateUser(
        email: String,
        user: User,
    ): User {
        val beforeUserInfo = userRepository.findByEmail(email)
        return if (beforeUserInfo == null) {
            throw Exception("변경 요청한 회원 정보가 없습니다.")
        } else {
            beforeUserInfo.lastName = user.lastName
            beforeUserInfo.firstName = user.firstName
            userRepository.save(beforeUserInfo)
        }
    }

    @Transactional
    fun updateUsers(
        usernames: List<String>,
        modifiedUsers: List<User>,
    ): List<User> {
        usernames.forEach {
            val fetchedUser = userRepository.findByUsername(it)
            if (fetchedUser == null) {
                throw Exception("변경하 실 회원 정보 리스트 일부에 회원 정보가 없습니다.")
            } else {
                userRepository.save(fetchedUser)
            }
        }
        return modifiedUsers
    }

    fun deleteUser(username: String): User {
        val user = userRepository.findByUsername(username)
        return if (user == null) {
            throw Exception("삭제 요청한 회원 정보가 없습니다.")
        } else {
            user.status = Status.DELETE.name
            user.deleteAt = LocalDateTime.now()
            userRepository.save(user)
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(UserService::class.java)
    }
}
