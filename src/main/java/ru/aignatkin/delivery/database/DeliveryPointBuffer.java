package ru.aignatkin.delivery.database;

public class DeliveryPointBuffer {
    private String name;
    private Float coordinates_l;
    private Float coordinates_w;
    private Double distance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getCoordinates_l() {
        return coordinates_l;
    }

    public void setCoordinates_l(Float coordinates_l) {
        this.coordinates_l = coordinates_l;
    }

    public Float getCoordinates_w() {
        return coordinates_w;
    }

    public void setCoordinates_w(Float coordinates_w) {
        this.coordinates_w = coordinates_w;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
