package com.aoj.softwareengnieer.data

import com.aoj.softwareengnieer.data.entity.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<CustomerEntity, String> {
}