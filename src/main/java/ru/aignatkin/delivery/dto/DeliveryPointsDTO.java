package ru.aignatkin.delivery.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DeliveryPointsDTO {
    @JsonProperty("deliveryPoints")
    private List<DeliveryPointDTO> deliveryPoints;

    @JsonProperty("deliveryPoints")
    public List<DeliveryPointDTO> getDeliveryPointDTO() {
        return this.deliveryPoints;
    }

    @JsonProperty("deliveryPoints")
    public void setDeliveryPoints(List<DeliveryPointDTO> deliveryPoints) {
        this.deliveryPoints = deliveryPoints;
    }
}
