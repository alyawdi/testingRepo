package com.noema.retail

import com.noema.retail.entities.productEntity
import com.noema.retail.entities.vendorEntity
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CoroutineCrudRepository<productEntity, String> {
    suspend fun findAllByVendorId(vendorId: String): List<productEntity>

    @Query({})
    suspend fun findAllMainVendors(): List<productEntity>

}


@Repository
interface VendorRepository : CoroutineCrudRepository<vendorEntity, String>
