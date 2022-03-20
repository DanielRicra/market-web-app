package com.tsdnl.market.persistence;

import com.tsdnl.market.domain.DomainPurchase;
import com.tsdnl.market.persistence.crud.PurchaseCrudRepository;
import com.tsdnl.market.persistence.entity.Purchase;
import com.tsdnl.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository  implements com.tsdnl.market.domain.repository.PurchaseRepository {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<DomainPurchase> getAll() {
        return mapper.toPurchases((List<Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<DomainPurchase>> getByCustomer(String customerId) {
        return purchaseCrudRepository.findByIdCustomer(customerId)
                .map(purchases -> mapper.toPurchases(purchases));
    }

    @Override
    public DomainPurchase save(DomainPurchase domainPurchase) {
        Purchase purchase = mapper.toPurchase(domainPurchase);
        purchase.getProducts().forEach(product -> product.setPurchase(purchase));
        return mapper.toDomainPurchase(purchaseCrudRepository.save(purchase));
    }
}
