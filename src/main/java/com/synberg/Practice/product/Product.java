package com.synberg.Practice.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a product entity stored in the database.
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Article is mandatory")
    @Column(name = "article", unique = true)
    private String article;

    @NotBlank(message = "Description is mandatory")
    @Column(name = "description")
    private String description;

    @NotBlank(message = "Category is mandatory")
    @Column(name = "category")
    private String category;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be positive")
    @Column(name = "price")
    private Double price;

    @NotNull(message = "Quantity is mandatory")
    @PositiveOrZero(message = "Quantity cannot be negative")
    @Column(name = "quantity")
    private Integer quantity;

    @NotNull(message = "Last modified date is mandatory")
    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @NotNull(message = "Created date is mandatory")
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    /**
     * Retrieves the unique identifier of the product.
     *
     * @return UUID id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the product.
     *
     * @param id UUID id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the product.
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name String name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the article (unique identifier) of the product.
     *
     * @return String article
     */
    public String getArticle() {
        return article;
    }

    /**
     * Sets the article (unique identifier) of the product.
     *
     * @param article String article to set
     */
    public void setArticle(String article) {
        this.article = article;
    }

    /**
     * Retrieves the description of the product.
     *
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the product.
     *
     * @param description String description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the category of the product.
     *
     * @return String category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the product.
     *
     * @param category String category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Retrieves the price of the product.
     *
     * @return Double price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price Double price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Retrieves the quantity of the product.
     *
     * @return Integer quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product.
     *
     * @param quantity Integer quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Retrieves the last modified date of the product.
     *
     * @return LocalDateTime lastModified
     */
    public LocalDateTime getLastModified() {
        return lastModified;
    }

    /**
     * Sets the last modified date of the product.
     *
     * @param lastModified LocalDateTime lastModified to set
     */
    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * Retrieves the created date of the product.
     *
     * @return LocalDateTime createdDate
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the created date of the product.
     *
     * @param createdDate LocalDateTime createdDate to set
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
