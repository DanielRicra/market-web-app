package com.tsdnl.market.web.controller;

import com.tsdnl.market.domain.DomainPurchase;
import com.tsdnl.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("")
    public ResponseEntity<List<DomainPurchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<DomainPurchase>> getByCustomer(@PathVariable("id") String customerId) {
        return purchaseService.getByCustomer(customerId)
                .map(domainPurchases -> new ResponseEntity<>(domainPurchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<DomainPurchase> save(@RequestBody DomainPurchase domainPurchase) {
        return new ResponseEntity<>(purchaseService.save(domainPurchase), HttpStatus.CREATED);
    }
}
