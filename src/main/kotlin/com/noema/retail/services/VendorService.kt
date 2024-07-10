package com.noema.retail.services

import com.noema.retail.VendorRepository
import com.noema.retail.dtos.vendorDto
import com.noema.retail.toDto
import com.noema.retail.toNewEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service

@Service
class VendorServices(
    private val repository: VendorRepository,
) {
    suspend fun getAllVendor(): Flow<vendorDto> = repository.findAll().map { it.toDto() }
    suspend fun getVendorById(id: String): vendorDto =
        repository.findById(id)?.toDto() ?: throw Exception("Vendor not found")

    suspend fun createVendor(vendor: vendorDto): vendorDto = repository.save(vendor.toNewEntity()).toDto()

    suspend fun updateVendor(id: String, updateVendor: vendorDto): vendorDto {
        var existingVendor = repository.findById(id)?.toDto()

        existingVendor ?: throw Exception("Vendor not found")

        val updateVendor = existingVendor.copy(
            name = updateVendor.name,
            website = updateVendor.website,
            phoneNumber = updateVendor.phoneNumber,
        )

        existingVendor = updateVendor;
        return repository.save(existingVendor.toNewEntity()).toDto();
    }

    suspend fun deleteVendor(id: String) {
        return repository.deleteById(id);
    }
}