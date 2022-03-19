package com.tsdnl.market.persistence;

import com.tsdnl.market.persistence.crud.ProductCrudRepository;
import com.tsdnl.market.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private ProductCrudRepository productCRUDRepository;

    public List<Product> getAll() {
        return (List<Product>) productCRUDRepository.findAll();
    }

    public List<Product> getByCategory(int idCategory) {
        return productCRUDRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<Product>> getScarce(int quantity) {
        return productCRUDRepository.findByStockQuantityLessThanAndState(quantity, true);
    }

    public Optional<Product> getProduct(int idProduct) {
        return productCRUDRepository.findById(idProduct);
    }

    public Product save(Product product) {
        return productCRUDRepository.save(product);
    }

    public void delete(int idProduct) {
        productCRUDRepository.deleteById(idProduct);
    }
}
