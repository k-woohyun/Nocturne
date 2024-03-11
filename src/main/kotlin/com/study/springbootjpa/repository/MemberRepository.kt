package com.study.springbootjpa.repository

import com.study.springbootjpa.entity.Member
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long> {
    override fun findAll(pageable: Pageable): Page<Member>

    fun findByEmail(email: String): Member

    fun save(member: Member): Member
}
