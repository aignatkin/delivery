package ru.aignatkin.delivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

//@MappedSuperclass
@Entity
@Table(name = "delivery_points")
public class DeliveryPoints extends BaseEntity {
    @Column(name = "display_name")
    public String displayName;

    @Column(name = "partial_purchase")
    public String partialPurchase;

    public String getDisplayName() {
        return displayName;
    }

    public String getPartialPurchase() {
        return partialPurchase;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setPartialPurchase(String partialPurchase) {
        this.partialPurchase = partialPurchase;
    }
}
