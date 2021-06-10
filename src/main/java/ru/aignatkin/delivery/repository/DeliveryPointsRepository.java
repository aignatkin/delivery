package ru.aignatkin.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aignatkin.delivery.model.DeliveryPoints;

public interface DeliveryPointsRepository extends JpaRepository<DeliveryPoints, String> {

}
