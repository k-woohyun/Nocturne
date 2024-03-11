package com.study.springbootjpa.service

import com.study.springbootjpa.entity.Member
import com.study.springbootjpa.repository.MemberRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberServiceTest {

    @Autowired
    lateinit var memberRepository: MemberRepository;

    @Test
    fun getMembers() {
    }

    @Test
    fun setMembers() {
    }

    @Test
    fun findByAll() {

        var members: List<Member> = memberRepository.findAll()
        println("MEMBER ::: "+members)

    }
}
