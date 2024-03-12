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

    fun createMember(requestMember: Member): Member {
        return memberRepository.save(requestMember)
    }

    fun updateMemberInfo(
        email: String,
        member: Member,
    ): Member {
        val beforeMemberInfo = memberRepository.findByEmail(email)
        beforeMemberInfo.lastName = member.lastName
        beforeMemberInfo.firstName = member.firstName
        return memberRepository.save(beforeMemberInfo)
    }

    fun updateMember(
        userName: String,
        member: Member,
    ): Member {
        val beforeMemberInfo = memberRepository.findByUserName(userName)
        beforeMemberInfo.phone = member.phone
        beforeMemberInfo.lastName = member.lastName
        beforeMemberInfo.firstName = member.firstName
        beforeMemberInfo.email = member.email
        return memberRepository.save(beforeMemberInfo)
    }

    fun deleteMember(userName: String) {
        val member = memberRepository.findByUserName(userName)
        return memberRepository.delete(member)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MemberService::class.java)
    }
}
