package com.study.springbootjpa.service

import com.study.springbootjpa.entity.Member
import com.study.springbootjpa.repository.MemberRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class MemberService(private val memberRepository: MemberRepository) {

    private val logger = LoggerFactory.getLogger(MemberService::class.java)

    var members: List<Member> = mutableListOf()

    fun findByAll() {
        members =  memberRepository.findAll()
        logger.info("members :: {}", members)
    }

}
