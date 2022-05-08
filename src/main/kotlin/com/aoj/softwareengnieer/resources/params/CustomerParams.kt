package com.aoj.softwareengnieer.resources.params

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class CustomerParams(
    @NotBlank(message = "O nome do cliente não pode estar em branco")
    val name: String,
    @NotEmpty(message = "O nome da cidade não pode estar em branco")
    val city: String,
)
