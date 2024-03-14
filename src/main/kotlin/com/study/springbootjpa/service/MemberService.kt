package com.study.springbootjpa.service

import com.study.springbootjpa.entity.Member
import com.study.springbootjpa.repository.MemberRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(private val memberRepository: MemberRepository) {
    fun findAll(pageable: Pageable): Page<Member> {
        return memberRepository.findAll(pageable)
    }

    fun findByEmail(email: String): Member {
        return memberRepository.findByEmail(email)
    }

    @Transactional
    fun createMember(member: Member): Member {
        val checkUser = memberRepository.existsByUsername(member.username)
        return if (checkUser) {
            throw Exception("이미 등록된 회원정보입니다.")
        } else {
            memberRepository.save(member)
        }
    }

    @Transactional
    fun updateMemberInfo(
        email: String,
        member: Member,
    ): Member {
        val beforeMemberInfo = memberRepository.findByEmail(email)
        beforeMemberInfo.lastName = member.lastName
        beforeMemberInfo.firstName = member.firstName
        return memberRepository.save(beforeMemberInfo)
    }

    @Transactional
    fun updateMember(
        usernames: List<String>,
        modifiedMembers: List<Member>,
    ): List<Member> {
        usernames.forEach {
            val fetchedMember = memberRepository.findByUsername(it)
            memberRepository.save(fetchedMember)
        }
        return modifiedMembers
    }

    fun deleteMember(username: String) {
        val member = memberRepository.findByUsername(username)
        return memberRepository.delete(member)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MemberService::class.java)
    }
}
