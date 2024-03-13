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

    fun createMember(requestMember: Member): String {
        val checkUser = memberRepository.existsByUsername(requestMember.username)
        return if (checkUser) {
            memberRepository.save(requestMember)
            "회원 등록 완료"
        } else {
            "중복된 회원 입니다."
        }
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
        val beforeMemberInfo = memberRepository.findByUsername(userName)
        beforeMemberInfo.phone = member.phone
        beforeMemberInfo.lastName = member.lastName
        beforeMemberInfo.firstName = member.firstName
        beforeMemberInfo.email = member.email
        return memberRepository.save(beforeMemberInfo)
    }

    fun deleteMember(userName: String) {
        val member = memberRepository.findByUsername(userName)
        return memberRepository.delete(member)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MemberService::class.java)
    }
}
