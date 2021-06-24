package ru.aignatkin.delivery.service;

import ru.aignatkin.delivery.dto.DeliveryPointsDTO;
import ru.aignatkin.delivery.exception.DeliveryPointException;

public interface DeliveryPointsService {
    DeliveryPointsDTO getAll();
    DeliveryPointsDTO getId(String name) throws DeliveryPointException;
    DeliveryPointsDTO getNearest(float coordinate_w, float coordinate_l) throws DeliveryPointException;
    void save (DeliveryPointsDTO deliveryPointsDTO) throws DeliveryPointException;
}