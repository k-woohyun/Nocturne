package com.study.springbootjpa.repository

import com.study.springbootjpa.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long> {
    fun findByEmail(email: String): Member?

    fun findByUsername(userName: String): Member?

    fun existsByUsername(username: String): Boolean
}
