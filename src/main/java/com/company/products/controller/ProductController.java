package com.company.products.controller;

import com.company.products.entity.Product;
import com.company.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public String home() {
        System.out.println("Home page accessed");
        return "forward:/products";
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "products/products-list";
    }

    @GetMapping("/products/addNewProduct")
    public String showAddNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/new";
    }

    @PostMapping("/products/addNewProduct")
    public String addNewProduct(@ModelAttribute @Valid Product product,
                                BindingResult result) {
        if (result.hasErrors()) {
            return "products/new";
        }
        productService.save(product);
        return "redirect:/products";
    }

    @PostMapping("/products/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {

        productService.deleteById(id);
        System.out.println("delete method called with id: " + id);
        return "redirect:/products";
    }

    @GetMapping("/products/updateProduct/{id}")
    public String showUpdateProductForm(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("productId", id);
        return "products/updateProduct";
    }

    @PostMapping("/products/updateProduct/{id}")
    public String updateProduct(@PathVariable int id,
                                @ModelAttribute(value = "product") @Valid Product formProduct,
                                BindingResult result,
                                Model model) {

        if (result.hasErrors()) {
            model.addAttribute("productId", id);
            return "/products/updateProduct";
        }
        productService.update(formProduct);
        return "redirect:/products";
    }
}
