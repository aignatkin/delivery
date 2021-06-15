package ru.aignatkin.delivery.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryPointDTO {
    public String name;
    public String displayName;
    public String partialPurchase;
    public String active;
    public Float[] coordinates;
    @JsonIgnore
    public Float coordinates_l;
    @JsonIgnore
    public Float coordinates_w;

    @JsonProperty("address")
    public AddressDTO address;

    @JsonIgnore
    public String appartment;

    @JsonIgnore
    public String building;

    @JsonIgnore
    public String country;

    @JsonIgnore
    public String phone;

    @JsonIgnore
    public String streetName;

    @JsonIgnore
    public String streetNumber;

    @JsonIgnore
    public String townName;

    public void initGet () {
        this.coordinates_l = this.coordinates[0];
        this.coordinates_w = this.coordinates[1];

        this.appartment = address.getAppartment();
        this.building = address.getBuilding();
        this.country = address.getCountry();
        this.phone = address.getPhone();
        this.streetName = address.getStreetName();
        this.streetNumber = address.getStreetNumber();
        this.townName = address.getTownName();
    }

    public void initSet () {
        coordinates = new Float[2];
        this.coordinates[0] = this.coordinates_l;
        this.coordinates[1] = this.coordinates_w;

        address = new AddressDTO();
        address.setAppartment(this.appartment);
        address.setBuilding(this.building);
        address.setCountry(this.country);
        address.setPhone(this.phone);
        address.setStreetName(this.streetName);
        address.setStreetNumber(this.streetNumber);
        address.setTownName(this.townName);
    }

    public String getName() {
        return name;
    }
    public String getDisplayName() {
        return displayName;
    }
    public String getPartialPurchase() {
        return partialPurchase;
    }
    public String getActive() { return active; }
    public String getAppartment() { return appartment; }

    @JsonProperty("address")
    public AddressDTO getAddressDTO() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public void setPartialPurchase(String partialPurchase) {
        this.partialPurchase = partialPurchase;
    }
    public void setActive(String active) { this.active = active; }
    public void setAppartment(String appartment) { this.appartment = appartment; }

    @JsonProperty("address")
    public void setAddressDTO(AddressDTO addressDTO) {
        this.address = addressDTO;
    }
}
