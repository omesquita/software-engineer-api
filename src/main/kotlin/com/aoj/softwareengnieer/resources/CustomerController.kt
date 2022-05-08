package com.aoj.softwareengnieer.resources

import com.aoj.softwareengnieer.domain.CreateCustomerUseCase
import com.aoj.softwareengnieer.domain.DeleteCustomerUseCase
import com.aoj.softwareengnieer.domain.GetAllCustomersUseCase
import com.aoj.softwareengnieer.domain.GetCustomerByIdUseCase
import com.aoj.softwareengnieer.domain.exception.CustomerNotFoundException
import com.aoj.softwareengnieer.resources.mapper.toResponse
import com.aoj.softwareengnieer.resources.params.CustomerParams
import com.aoj.softwareengnieer.resources.response.CustomerResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/customers")
class CustomerController(
    private val getAllCustomersUseCase: GetAllCustomersUseCase,
    private val getCustomerByIdUseCase: GetCustomerByIdUseCase,
    private val createCustomerUseCase: CreateCustomerUseCase,
    private val deleteCustomerUseCase: DeleteCustomerUseCase,
) {

    @GetMapping
    fun getAllCustomers(): ResponseEntity<List<CustomerResponse>> {
        val customers = getAllCustomersUseCase(Unit).map { customerEntity -> customerEntity.toResponse() }
        return ResponseEntity.ok(customers)
    }

    @GetMapping("/{customerId}")
    fun getCustomerById(@PathVariable customerId: String): ResponseEntity<Any> {
        val optCustomer = getCustomerByIdUseCase(customerId)

        return if (optCustomer.isPresent) {
            val response = optCustomer.get().toResponse()
            ResponseEntity.ok(response)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado com o id informado")
        }
    }

    @PostMapping
    fun addCustomer(@Valid @RequestBody params: CustomerParams): ResponseEntity<CustomerResponse> {
        val customer = createCustomerUseCase(params)
        return ResponseEntity.ok(customer.toResponse())
    }

    @DeleteMapping("/{customerId}")
    fun deleteCustomerById(@PathVariable customerId: String): ResponseEntity<Any> = try {
        deleteCustomerUseCase(customerId)
        ResponseEntity.ok(Unit)
    } catch (ex: CustomerNotFoundException) {
        ResponseEntity.status(HttpStatus.NOT_FOUND).body("Falha ao excluir. Id do cliente não encontrado")
    }
}
