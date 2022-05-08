package com.aoj.softwareengnieer.domain

import com.aoj.softwareengnieer.arch.UseCase
import com.aoj.softwareengnieer.data.CustomerRepository
import com.aoj.softwareengnieer.data.entity.CustomerEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class GetCustomerByIdUseCase(
    private val customerRepository: CustomerRepository,
) : UseCase<String, Optional<CustomerEntity>>() {

    override fun execute(params: String): Optional<CustomerEntity> = customerRepository.findById(params)
}
