package com.study.springbootjpa.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "member")
data class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "email")
    var email: String,
    @Column(name = "last_name")
    var lastName: String,
    @Column(name = "first_name")
    var firstName: String,
    @Column(name = "phone")
    var phone: String,
    @Column(name = "user_name")
    var userName: String,
)
