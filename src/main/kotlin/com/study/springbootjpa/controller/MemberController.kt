package com.study.springbootjpa.controller

import com.study.springbootjpa.entity.Member
import com.study.springbootjpa.service.MemberService
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(private val memberService: MemberService) {
    @GetMapping("/api/v1/members")
    fun findAll(
        @PageableDefault(size = 12) pageable: Pageable,
    ): Page<Member> {
        return memberService.findAll(pageable)
    }

    @GetMapping("/api/v1/members/{email}")
    fun findByEmail(
        @PathVariable email: String,
    ): Member {
        return memberService.findByEmail(email)
    }

    @PostMapping("/api/v1/members")
    fun createMember(
        @RequestBody member: Member,
    ): Member {
        return memberService.createMember(member)
    }

    @PatchMapping("/api/v1/members/{email}")
    fun patchMember(
        @PathVariable email: String,
        @RequestBody member: Member,
    ): Member {
        return memberService.patchMember(email, member)
    }

    @PutMapping("/api/v1/members/{userId}")
    fun putMember(
        @PathVariable userId: String,
        @RequestBody member: Member,
    ): Member {
        return memberService.putMember(userId, member)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MemberController::class.java)
    }
}
