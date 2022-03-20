package com.tsdnl.market.domain.service;

import com.tsdnl.market.domain.DomainPurchase;
import com.tsdnl.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<DomainPurchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<DomainPurchase>> getByCustomer(String customerId) {
            return purchaseRepository.getByCustomer(customerId);
    }

    public DomainPurchase save(DomainPurchase purchase) {
        return purchaseRepository.save(purchase);
    }

}
