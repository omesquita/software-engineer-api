package com.aoj.softwareengnieer.data.entity

import org.hibernate.annotations.DynamicUpdate
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@DynamicUpdate
@Table(name = "customer")
data class CustomerEntity(
    @Id
    @Column(name = "id")
    var id: String,

    @Column(name = "name")
    val name: String,

    @Column(name = "city")
    val city: String,

    @Column(name = "created_at")
    val createdAt: LocalDate,
)
