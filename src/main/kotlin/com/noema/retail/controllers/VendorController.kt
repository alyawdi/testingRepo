package com.noema.retail.controllers

import com.noema.retail.dtos.vendorDto
import com.noema.retail.entities.vendorEntity
import com.noema.retail.services.VendorServices
import kotlinx.coroutines.flow.Flow
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(
    "/vendors",
    /*those consumer and produces are for choosing which type of files is used to transfer data */
    consumes = [MediaType.APPLICATION_JSON_VALUE],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class VendorController(
    private val vendorServices: VendorServices
) {

    @GetMapping("/")
    suspend fun getAllVendors(): Flow<vendorDto> {
        return vendorServices.getAllVendor();
    }

    @GetMapping("/{id}")
    suspend fun getVendor(@PathVariable id: String): vendorDto {
        return vendorServices.getVendorById(id) ?: throw Exception("Vendor not found");
    }

    @PostMapping
    suspend fun addVendor(@RequestBody vendor: vendorDto): vendorDto {
        return vendorServices.createVendor(vendor);
    }

    @PutMapping("/{id}")
    suspend fun updateVendor(@PathVariable id: String, @RequestBody vendor: vendorDto): vendorDto {
        return vendorServices.updateVendor(id, vendor);
    }

    @DeleteMapping("/{id}")
    suspend fun deleteVendor(@PathVariable id: String) {
        return vendorServices.deleteVendor(id);
    }

}