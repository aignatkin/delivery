package ru.aignatkin.delivery.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.aignatkin.delivery.dto.DeliveryPointDTO;
import ru.aignatkin.delivery.model.DeliveryPoint;

@Mapper(componentModel = "spring")
public abstract class DeliveryPointAfterMapping {

    @AfterMapping
    protected void setCoordinate (DeliveryPoint deliveryPoint, @MappingTarget DeliveryPointDTO deliveryPointDTO) {
        deliveryPointDTO.setCoordinates(new Float[2]);
        deliveryPointDTO.getCoordinates()[0] = deliveryPoint.getCoordinates_l();
        deliveryPointDTO.getCoordinates()[1] = deliveryPoint.getCoordinates_w();
    }
}