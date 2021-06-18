package ru.aignatkin.delivery.dto;

public class DeliveryPointDTO {
    private String name;
    private String displayName;
    private String partialPurchase;
    private String active;
    private Float[] coordinates;
    private AddressDTO address;

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
    public AddressDTO getAddress() { return address; }
    public Float[] getCoordinates() {
        return coordinates;
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
    public void setAddress(AddressDTO address) { this.address = address; }
    public void setCoordinates(Float[] coordinates) {
        this.coordinates = coordinates;
    }
}
