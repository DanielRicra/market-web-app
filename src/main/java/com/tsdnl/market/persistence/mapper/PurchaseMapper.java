package com.tsdnl.market.persistence.mapper;

import com.tsdnl.market.domain.DomainPurchase;
import com.tsdnl.market.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idPurchase", target = "purchaseId"),
            @Mapping(source = "idCustomer", target = "customerId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(source = "state", target = "state"),
            @Mapping(source = "products", target = "items")
    })
    DomainPurchase toDomainPurchase(Purchase purchase);
    List<DomainPurchase> toPurchases(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "customer", ignore = true)
    Purchase toPurchase(DomainPurchase purchase);
}
