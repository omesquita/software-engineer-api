package com.aoj.softwareengnieer.domain

import com.aoj.softwareengnieer.arch.UseCase
import com.aoj.softwareengnieer.data.CustomerRepository
import com.aoj.softwareengnieer.data.entity.CustomerEntity
import org.springframework.stereotype.Component

@Component
class GetAllCustomersUseCase(
    private val customerRepository: CustomerRepository,
) : UseCase<Unit, List<CustomerEntity>>() {

    override fun execute(params: Unit): List<CustomerEntity> = customerRepository.findAll()
}
