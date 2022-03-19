package com.tsdnl.market.web.controller;

import com.tsdnl.market.domain.DomainProduct;
import com.tsdnl.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    public List<DomainProduct>  getAll() {
        return productService.getAll();
    }

    public Optional<DomainProduct> getProduct(int productId) {
        return productService.getProduct(productId);
    }

    public Optional<List<DomainProduct>> getByCategory(int categoryId) {
        return productService.getByCategory(categoryId);
    }

    public DomainProduct save(DomainProduct product) {
        return productService.save(product);
    }

    public boolean delete(int productId) {
        return productService.delete(productId);
    }
}
