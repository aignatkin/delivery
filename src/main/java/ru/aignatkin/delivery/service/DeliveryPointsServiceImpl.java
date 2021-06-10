package ru.aignatkin.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aignatkin.delivery.model.DeliveryPoints;
import ru.aignatkin.delivery.repository.DeliveryPointsRepository;

import java.util.List;

@Service
public class DeliveryPointsServiceImpl implements DeliveryPointsService {
    @Autowired
    DeliveryPointsRepository deliveryPointsRepository;

    @Override
    public List<DeliveryPoints> getAll() {
        return deliveryPointsRepository.findAll();
    }

    @Override
    public void save(DeliveryPoints deliveryPoints) {
        System.out.println("Request! " + deliveryPoints.displayName);
        deliveryPointsRepository.save(deliveryPoints);
    }
}
