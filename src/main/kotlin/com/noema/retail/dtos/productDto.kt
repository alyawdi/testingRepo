package com.noema.retail.dtos

import org.springframework.data.annotation.Id

data class productDto(

    val id: String? = null,
    val name: String,
    val price: Double,
    val vendorId: String,
)
