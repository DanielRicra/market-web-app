package com.tsdnl.market.domain.repository;

import com.tsdnl.market.domain.DomainPurchase;
import com.tsdnl.market.domain.PurchaseItem;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<DomainPurchase> getAll();
    Optional<List<DomainPurchase>> getByCustomer(String customerId);
    DomainPurchase save(DomainPurchase purchase);
}
