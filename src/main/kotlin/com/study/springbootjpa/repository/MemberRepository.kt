package com.study.springbootjpa.repository

import com.study.springbootjpa.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface MemberRepository : JpaRepository<Member, Int> {
    fun findAllByEmail(email: String): Member
}
