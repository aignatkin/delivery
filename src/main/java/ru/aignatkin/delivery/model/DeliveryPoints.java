package ru.aignatkin.delivery.model;

import javax.persistence.*;

@Entity
@Table(name = "delivery_points")
public class DeliveryPoints {
    @Id
    @Column(name = "name", length = 20)
    public String name;

    @Column(name = "display_name", length = 50, nullable = false)
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

    public void setName(String name) {this.name = name;}

    public String getName() {return name;}
}
