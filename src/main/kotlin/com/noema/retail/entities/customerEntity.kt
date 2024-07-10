package com.noema.retail.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("customers")
data class customerEntity(
    @Id
    val id: String? = null,
    val name: String,
    val email: String,
    val phone: String,
)
