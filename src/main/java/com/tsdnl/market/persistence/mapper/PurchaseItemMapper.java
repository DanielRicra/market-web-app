package com.tsdnl.market.persistence.mapper;

import com.tsdnl.market.domain.PurchaseItem;
import com.tsdnl.market.persistence.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "state", target = "active")
    })
    PurchaseItem toPurchaseItem(PurchaseProduct product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idPurchase", ignore = true),
    })
    PurchaseProduct toPurchaseProduct(PurchaseItem purchaseItem);
}
