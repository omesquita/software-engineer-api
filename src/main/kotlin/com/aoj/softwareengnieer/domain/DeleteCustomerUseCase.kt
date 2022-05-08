package com.aoj.softwareengnieer.domain

import com.aoj.softwareengnieer.arch.UseCase
import com.aoj.softwareengnieer.data.CustomerRepository
import com.aoj.softwareengnieer.domain.exception.CustomerNotFoundException
import org.springframework.stereotype.Component

@Component
class DeleteCustomerUseCase(
    private val customerRepository: CustomerRepository,
    private val getCustomerByIdUseCase: GetCustomerByIdUseCase,
) : UseCase<String, Unit>() {

    override fun execute(params: String) {
        val optCustomer = getCustomerByIdUseCase(params)
        if (optCustomer.isPresent) {
            customerRepository.delete(optCustomer.get())
        } else {
            throw CustomerNotFoundException("Não foi possível deletar, cliente não encontrado")
        }
    }
}
