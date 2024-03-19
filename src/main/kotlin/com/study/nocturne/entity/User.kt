package com.study.nocturne.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "user")
data class User(
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
    var username: String,
    @Column(name = "status")
    var status: Status,
    @Column(name = "delete_at")
    var deleteAt: LocalDateTime,
)
