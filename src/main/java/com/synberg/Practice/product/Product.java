package com.synberg.Practice.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
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

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
