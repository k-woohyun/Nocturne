package com.study.springbootjpa.repository

import com.study.springbootjpa.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long> {
    fun findByEmail(email: String): Member

    fun findByUserName(userName: String): Member
}
