package com.noema.retail

import com.noema.retail.dtos.productDto
import com.noema.retail.dtos.vendorDto
import com.noema.retail.entities.productEntity
import com.noema.retail.entities.vendorEntity


fun productDto.toNewEntity() = productEntity(
    name = name,
    price = price,
    vendorId = vendorId,
)

fun productEntity.toDto() = productDto(
    id = id,
    name = name,
    price = price,
    vendorId = vendorId,
)

fun vendorDto.toNewEntity() = vendorEntity(
    name = name,
    website = website,
    phoneNumber = phoneNumber,
)

fun vendorEntity.toDto() = vendorDto(
    id = id,
    name = name,
    website = website,
    phoneNumber = phoneNumber,
)