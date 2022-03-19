package com.tsdnl.market.persistence.crud;

import com.tsdnl.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCRUDRepository extends CrudRepository<Product, Integer> {


}
