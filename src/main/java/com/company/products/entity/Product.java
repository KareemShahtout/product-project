package com.company.products.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(length = 11)
    @Getter
    private int id;

    @Setter
    @Getter
    @Column(length = 50)
    private String name;

    @Getter
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
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
