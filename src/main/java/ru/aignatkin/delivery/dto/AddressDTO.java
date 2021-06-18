package ru.aignatkin.delivery.dto;

public class AddressDTO {
    private String appartment;
    private String building;
    private String country;
    private String phone;
    private String streetName;
    private String streetNumber;
    private String townName;

    public String getAppartment() { return appartment; }
    public String getBuilding() { return building; }
    public String getCountry() { return country; }
    public String getPhone() { return phone; }
    public String getStreetName() { return streetName; }
    public String getStreetNumber() { return streetNumber; }
    public String getTownName() { return townName; }

    public void setAppartment(String appartment) { this.appartment = appartment; }
    public void setBuilding(String building) { this.building = building; }
    public void setCountry(String country) { this.country = country; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setStreetName(String streetName) { this.streetName = streetName; }
    public void setStreetNumber(String streetNumber) { this.streetNumber = streetNumber; }
    public void setTownName(String townName) { this.townName = townName; }
}
