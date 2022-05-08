package com.aoj.softwareengnieer.resources.mapper

import com.aoj.softwareengnieer.data.entity.CustomerEntity
import com.aoj.softwareengnieer.resources.response.CustomerResponse
import com.aoj.softwareengnieer.utils.DateTimeUtils

fun CustomerEntity.toResponse() = CustomerResponse(
    name = name,
    city = city,
    createdAt = createdAt.format(DateTimeUtils.dateFormat)
)