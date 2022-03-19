package com.tsdnl.market.domain.service;

import com.tsdnl.market.domain.DomainProduct;
import com.tsdnl.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<DomainProduct> getAll(){
        return productRepository.getAll();
    }

    public Optional<DomainProduct> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<DomainProduct>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public DomainProduct save(DomainProduct domainProduct) {
        return productRepository.save(domainProduct);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}















