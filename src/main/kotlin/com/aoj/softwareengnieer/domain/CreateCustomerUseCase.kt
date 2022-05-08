package com.aoj.softwareengnieer.domain

import com.aoj.softwareengnieer.arch.UseCase
import com.aoj.softwareengnieer.data.CustomerRepository
import com.aoj.softwareengnieer.data.entity.CustomerEntity
import com.aoj.softwareengnieer.resources.params.CustomerParams
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.UUID

@Component
class CreateCustomerUseCase(
    private val customerRepository: CustomerRepository,
) : UseCase<CustomerParams, CustomerEntity>() {

    override fun execute(params: CustomerParams): CustomerEntity {
        val customer = CustomerEntity(
            id = generateCustomerUUID(),
            name = params.name,
            city = params.city,
            createdAt = getCurrentDate()
        )

        return customerRepository.save(customer)
    }

    private fun getCurrentDate() = LocalDate.now()

    private fun generateCustomerUUID() = UUID.randomUUID().toString()
}

