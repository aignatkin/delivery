package ru.aignatkin.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aignatkin.delivery.model.DeliveryPoint;


public interface DeliveryPointsRepository extends JpaRepository<DeliveryPoint, String> {

    //добавить метод, который работает с нативным запросом
    @Query
    @Native("")
    DeliveryPoint findByfdsfdsfds();

}
