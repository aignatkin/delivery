package ru.aignatkin.delivery.model;

import javax.persistence.*;

@Entity
@Table(name = "delivery_points")
public class DeliveryPoint {
    @Id
    @Column(name = "id_name", length = 20)
    public String name;

    @Column(name = "display_name", length = 50, nullable = false)
    public String displayName;

    @Column(name = "partial_purchase")
    public String partialPurchase;

    @Column(name = "active")
    public String active;

    @Column(name = "coordinates_l")
    public Float coordinates_l;

    @Column(name = "coordinates_w")
    public Float coordinates_w;

    @Column(name = "address_appartment")
    public String appartment;

    @Column(name = "address_building")
    public String building;

    @Column(name = "address_country")
    public String country;

    @Column(name = "address_phone")
    public String phone;

    @Column(name = "address_streetName")
    public String streetName;

    @Column(name = "address_streetNumber")
    public String streetNumber;

    @Column(name = "address_townName")
    public String townName;

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPartialPurchase() {
        return partialPurchase;
    }

    public Float getCoordinates_l() { return coordinates_l; }

    public Float getCoordinates_w() {
        return coordinates_w;
    }

    public String getActive() { return active; }

    public String getAppartment() { return appartment; }

    public String getBuilding() { return building; }

    public String getCountry() { return country; }

    public String getPhone() { return phone; }

    public String getStreetName() { return streetName; }

    public String getStreetNumber() { return streetNumber; }

    public String getTownName() { return townName; }

    public void setName(String name) {
        this.name = name;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setPartialPurchase(String partialPurchase) {
        this.partialPurchase = partialPurchase;
    }

    public void setCoordinates_l(Float coordinates_l) { this.coordinates_l = coordinates_l; }

    public void setCoordinates_w(Float coordinates_w) { this.coordinates_w = coordinates_w; }

    public void setActive(String active) { this.active = active; }

    public void setAppartment(String appartment) { this.appartment = appartment; }

    public void setBuilding(String building) { this.building = building; }

    public void setCountry(String country) { this.country = country; }

    public void setPhone(String phone) { this.phone = phone; }

    public void setStreetName(String streetName) { this.streetName = streetName; }

    public void setStreetNumber(String streetNumber) { this.streetNumber = streetNumber; }

    public void setTownName(String townName) { this.townName = townName; }
}
