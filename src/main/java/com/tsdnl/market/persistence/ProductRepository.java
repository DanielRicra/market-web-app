package com.tsdnl.market.persistence;

import com.tsdnl.market.domain.DomainProduct;
import com.tsdnl.market.persistence.crud.ProductCrudRepository;
import com.tsdnl.market.persistence.entity.Product;
import com.tsdnl.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements com.tsdnl.market.domain.repository.ProductRepository {
    @Autowired
    private ProductCrudRepository productCRUDRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<DomainProduct> getAll() {
        List<Product> products = (List<Product>) productCRUDRepository.findAll();
        return mapper.toDomainProducts(products);
    }

    @Override
    public Optional<List<DomainProduct>> getByCategory(int categoryId) {
        List<Product> products = productCRUDRepository.findByIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(mapper.toDomainProducts(products));
    }

    @Override
    public Optional<List<DomainProduct>> getScarceProducts(int quantity) {
        Optional<List<Product>> products = productCRUDRepository.findByStockQuantityLessThanAndState(quantity, true);
        return products.map(productList -> mapper.toDomainProducts(productList));
    }

    @Override
    public Optional<DomainProduct> getProduct(int productId) {
        return productCRUDRepository.findById(productId).map(product -> mapper.toProductDomain(product));
    }

    @Override
    public DomainProduct save(DomainProduct domainProduct) {
        Product product = mapper.toProduct(domainProduct);
        return mapper.toProductDomain(productCRUDRepository.save(product));
    }

    @Override
    public void delete(int productId) {
        productCRUDRepository.deleteById(productId);
    }
}
