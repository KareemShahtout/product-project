package com.company.products.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "manufacturer", length = 50)
    private String manufacturer;

    @Column(name = "price", nullable = false)
    private double price;

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
