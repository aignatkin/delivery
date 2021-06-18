package ru.aignatkin.delivery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.aignatkin.delivery.dto.DeliveryPointDTO;
import ru.aignatkin.delivery.model.DeliveryPoint;

@Mapper(componentModel = "spring", uses = {DeliveryPointMapperNew.class})
public interface DeliveryPointMapper {

    @Mapping(expression ="java(deliveryPointDTO.getCoordinates()[0])", target = "coordinates_l")
    @Mapping(expression ="java(deliveryPointDTO.getCoordinates()[1])", target = "coordinates_w")
    @Mapping(source = "address", target = ".")
    DeliveryPoint fromDTO (DeliveryPointDTO deliveryPointDTO);

    @Mapping(source = ".", target = "address")
    DeliveryPointDTO toDTO (DeliveryPoint deliveryPoint);
}
