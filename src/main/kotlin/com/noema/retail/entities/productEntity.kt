package com.noema.retail.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("products")
data class productEntity(
    @Id
    val id: String? = null,
    val name: String,
    val price: Double,
    val vendorId: String,
)
