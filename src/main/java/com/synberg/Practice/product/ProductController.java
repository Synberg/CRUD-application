package com.synberg.Practice.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Controller for managing products in the inventory.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Retrieves all products from the database.
     *
     * @return List of Product objects
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieves a product by its unique identifier.
     *
     * @param id UUID of the product to retrieve
     * @return ResponseEntity with the Product if found, or 404 Not Found if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a new product in the database.
     *
     * @param product Product object to create (validated using javax.validation annotations)
     * @return Product that was created
     */
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        product.setCreatedDate(LocalDateTime.now());
        product.setLastModified(LocalDateTime.now());
        return productRepository.save(product);
    }

    /**
     * Updates an existing product.
     *
     * @param id      UUID of the product to update
     * @param product Product object with updated information
     * @return ResponseEntity with the updated Product if successful, or 404 Not Found if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable UUID id, @Valid @RequestBody Product product) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();
            updatedProduct.setName(product.getName());
            updatedProduct.setArticle(product.getArticle());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setCategory(product.getCategory());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setQuantity(product.getQuantity());
            updatedProduct.setLastModified(LocalDateTime.now());
            return ResponseEntity.ok(productRepository.save(updatedProduct));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a product from the database.
     *
     * @param id UUID of the product to delete
     * @return ResponseEntity with a message indicating success or failure
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id) {
        try {
            productRepository.deleteById(id);
            return ResponseEntity.ok("Product deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Product not found");
        }
    }
}
