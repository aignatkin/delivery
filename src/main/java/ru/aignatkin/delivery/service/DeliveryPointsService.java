package ru.aignatkin.delivery.service;

import ru.aignatkin.delivery.model.DeliveryPoints;
import java.util.List;

public interface DeliveryPointsService {
    List<DeliveryPoints> getAll ();
    void save (DeliveryPoints deliveryPoints);
}
