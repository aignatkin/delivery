package ru.aignatkin.delivery.service;

import ru.aignatkin.delivery.model.DeliveryPoint;

import java.util.List;

public interface DeliveryPointsService {
    List<DeliveryPoint> getAll ();
    List<DeliveryPoint> getId (String name);
    void save (DeliveryPoint deliveryPoint);
}