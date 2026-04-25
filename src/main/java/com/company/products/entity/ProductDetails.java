package com.company.products.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "products_details")
@NoArgsConstructor
@Setter
@Getter
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11)
    private int id;

    @NotBlank(message = "Product name is required")
    @Size(max = 50, min = 3, message = "Name must be between 3 and 50 characters")
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Future(message = "Expiration date must be in the future")
    @Column(name = "expiration_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;

    @Size(max = 50, min = 2, message = "Manufacturer must be between 2 and 50 characters")
    @Column(name = "manufacturer", length = 50)
    private String manufacturer;

    @Positive(message = "Price must be greater than 0")
    @NotNull(message = "Price is required")
    @Column(name = "price", nullable = false)
    private double price;

    @NotNull(message = "Availability is required")
    @Min(value = 0, message = "Available must be 0 or 1")
    @Max(value = 1, message = "Available must be 0 or 1")
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private byte available;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;


    @Override
    public String toString() {
        return "ProductDetails{" +
                "available=" + available +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                ", expirationDate=" + expirationDate +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
