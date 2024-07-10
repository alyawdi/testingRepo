package com.noema.retail.controllers

import com.noema.retail.dtos.productDto
import com.noema.retail.services.ProductServices
import kotlinx.coroutines.flow.Flow
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(
    "/products",
    consumes = [MediaType.APPLICATION_JSON_VALUE],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class ProductController(
    private val productServices: ProductServices
) {

    @GetMapping("/")
    suspend fun getAllProducts(): Flow<productDto> {
        return productServices.findAllProducts();
    }

    @GetMapping("/{id}")
    suspend fun getProduct(@PathVariable id: String): productDto {
        return productServices.getProductById(id) ?: throw Exception("Product not found");
    }

    @PostMapping
    suspend fun addProduct(@RequestBody product: productDto) {
        return productServices.createProduct(product);
    }

    @PutMapping("/{id}")
    suspend fun updateProduct(@PathVariable id: String, @RequestBody product: productDto) {
        return productServices.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    suspend fun deleteProduct(@PathVariable id: String) {
        return productServices.deleteProduct(id);
    }

    @GetMapping
    suspend fun findProductsByVendorId(vendorId: String): List<productDto> {
        return productServices.findAllByVendorId(vendorId);
    }


}