package com.tsdnl.market.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "shopping")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idPurchase;

    @Column(name = "id_cliente")
    private String idCustomer;

    @Column(name = "fecha")
    private LocalDateTime date;

    @Column(name = "medio_pago")
    private String paymentMethod;

    @Column(name = "commentario")
    private String comment;

    @Column(name = "estado")
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "product")
    private List<PurchaseProduct> products;

    public Integer getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Integer idPurchase) {
        this.idPurchase = idPurchase;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
