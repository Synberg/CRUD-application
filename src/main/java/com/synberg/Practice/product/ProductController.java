package com.synberg.Practice.product;

import com.synberg.Practice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * REST controller for managing products.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Get all products.
     *
     * @return a list of all products
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Get a product by its ID.
     *
     * @param id the UUID of the product
     * @return the product with the specified ID
     * @throws ResourceNotFoundException if the product with the specified ID is not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        return ResponseEntity.ok(product);
    }

    /**
     * Create a new product.
     *
     * @param product the product to create
     * @return the created product
     */
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        product.setCreatedDate(LocalDateTime.now());
        product.setLastModified(LocalDateTime.now());
        return productRepository.save(product);
    }

    /**
     * Update an existing product.
     *
     * @param id the UUID of the product to update
     * @param productDetails the product details to update
     * @return the updated product
     * @throws ResourceNotFoundException if the product with the specified ID is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable UUID id, @RequestBody Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        product.setName(productDetails.getName());
        product.setArticle(productDetails.getArticle());
        product.setDescription(productDetails.getDescription());
        product.setCategory(productDetails.getCategory());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        product.setLastModified(LocalDateTime.now());

        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * Delete a product by its ID.
     *
     * @param id the UUID of the product to delete
     * @return a response indicating the result of the delete operation
     * @throws ResourceNotFoundException if the product with the specified ID is not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        productRepository.delete(product);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
