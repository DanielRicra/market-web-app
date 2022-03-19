package com.tsdnl.market.persistence.mapper;

import com.tsdnl.market.domain.DomainProduct;
import com.tsdnl.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
        @Mapping(source = "idProduct", target = "productId"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "idCategory", target = "categoryId"),
        @Mapping(source = "salePrice", target = "price"),
        @Mapping(source = "stockQuantity", target = "stock"),
        @Mapping(source = "state", target = "active"),
        @Mapping(source = "category", target = "category"),
    })
    DomainProduct toProductDomain(Product product);
    List<DomainProduct> toDomainProducts(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    Product toProduct(DomainProduct domainProduct);
}
