package com.tsdnl.market.domain;

import java.time.LocalDateTime;
import java.util.List;

public class DomainPurchase {
    private int purchaseId;
    private String costumerId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private boolean state;
    private List<DomainPurchase> items;

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(String costumerId) {
        this.costumerId = costumerId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public List<DomainPurchase> getItems() {
        return items;
    }

    public void setItems(List<DomainPurchase> item) {
        this.items = item;
    }
}
