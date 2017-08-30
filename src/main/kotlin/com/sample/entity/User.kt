package com.sample.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.seasar.doma.*
import java.sql.Timestamp

@Entity(immutable = true)
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        @JsonIgnore
        val password: String,
        val screenName: String,
        val displayName: String,
        val createdAt: Timestamp = Timestamp(System.currentTimeMillis())
)