package com.company.products.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(name = "products")
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(length = 11)
    @Getter
    @Setter
    private int id;

    @Setter
    @Getter
    @Column(length = 50)
    private String name;

    @Getter
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @Valid
    private ProductDetails productDetails;

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
        productDetails.setProduct(this);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productDetails=" + productDetails +
                '}';
    }
}
