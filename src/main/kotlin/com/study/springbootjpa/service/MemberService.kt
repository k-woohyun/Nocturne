package com.study.springbootjpa.service

import com.study.springbootjpa.entity.Member
import com.study.springbootjpa.repository.MemberRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class MemberService(private val memberRepository: MemberRepository) {
    fun findAll(pageable: Pageable): Page<Member> {
        return memberRepository.findAll(pageable)
    }

    fun findByEmail(email: String): Member {
        return memberRepository.findByEmail(email)
    }

    fun createMember(member: Member): Member {
        return memberRepository.save(member)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MemberService::class.java)
    }
}
