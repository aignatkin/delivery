package ru.aignatkin.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aignatkin.delivery.model.DeliveryPoint;
import ru.aignatkin.delivery.repository.DeliveryPointsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryPointsServiceImpl implements DeliveryPointsService {
    @Autowired
    DeliveryPointsRepository deliveryPointsRepository;

    @Override
    public List<DeliveryPoint> getAll() {
        return this.deliveryPointsRepository.findAll();
    }

    @Override
    public List<DeliveryPoint> getId(String name) {
        List<DeliveryPoint> deliveryPointList = new ArrayList<>();
        deliveryPointList.add(this.deliveryPointsRepository.getOne(name));
        return deliveryPointList;
    }

    @Override
    public void save(DeliveryPoint deliveryPoints) {
        this.deliveryPointsRepository.save(deliveryPoints);
    }
}
