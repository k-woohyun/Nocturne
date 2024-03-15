package com.study.springbootjpa.service

import com.study.springbootjpa.entity.Member
import com.study.springbootjpa.repository.MemberRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.NullPointerException

@Service
class MemberService(private val memberRepository: MemberRepository) {
    fun findAll(pageable: Pageable): Page<Member> {
        return memberRepository.findAll(pageable)
    }

    fun findByEmail(email: String): Member? {
        return memberRepository.findByEmail(email) ?: throw NullPointerException("찾으시는 회원 정보가 없습니다.")
    }

    @Transactional
    fun createMember(member: Member): Member {
        val checkUser = memberRepository.existsByUsername(member.username)
        return if (checkUser) {
            throw Exception("이미 등록된 회원 정보 입니다.")
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
        return if (beforeMemberInfo == null) {
            throw Exception("변경 요청한 회원 정보가 없습니다.")
        } else {
            beforeMemberInfo.lastName = member.lastName
            beforeMemberInfo.firstName = member.firstName
            memberRepository.save(beforeMemberInfo)
        }
    }

    @Transactional
    fun updateMembers(
        usernames: List<String>,
        modifiedMembers: List<Member>,
    ): List<Member> {
        usernames.forEach {
            val fetchedMember = memberRepository.findByUsername(it)
            if (fetchedMember == null) {
                throw Exception("변경하 실 회원 정보 리스트 일부에 회원 정보가 없습니다.")
            } else {
                memberRepository.save(fetchedMember)
            }
        }
        return modifiedMembers
    }

    fun deleteMember(username: String) {
        val member = memberRepository.findByUsername(username)
        return if (member == null) {
            throw Exception("삭제 요청한 회원 정보가 없습니다.")
        } else {
            memberRepository.delete(member)
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MemberService::class.java)
    }
}
