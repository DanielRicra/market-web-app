package com.tsdnl.market.domain.repository;

import com.tsdnl.market.domain.PurchaseItem;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<PurchaseItem> getAll();
    Optional<List<PurchaseItem>> getByCustomer(String customerId);
    PurchaseItem save(PurchaseItem purchase);
}
