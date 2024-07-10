package com.noema.retail.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("vendors")
data class vendorEntity(
    @Id
    val id: String? = null,
    val name: String,
    val website: String,
    val phoneNumber: String
)
