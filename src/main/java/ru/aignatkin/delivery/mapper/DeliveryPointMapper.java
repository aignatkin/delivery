package ru.aignatkin.delivery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.aignatkin.delivery.dto.DeliveryPointDTO;
import ru.aignatkin.delivery.model.DeliveryPoint;

import java.util.List;

@Mapper
public interface DeliveryPointMapper {
    DeliveryPointMapper INSTANCE = Mappers.getMapper(DeliveryPointMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "displayName", target = "displayName")
    @Mapping(source = "active", target = "active")
    @Mapping(source = "partialPurchase", target = "partialPurchase")
    @Mapping(source = "appartment", target = "appartment")
    @Mapping(source = "building", target = "building")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "streetName", target = "streetName")
    @Mapping(source = "streetNumber", target = "streetNumber")
    @Mapping(source = "townName", target = "townName")
    DeliveryPoint fromDTO (DeliveryPointDTO deliveryPointDTO);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "displayName", target = "displayName")
    @Mapping(source = "active", target = "active")
    @Mapping(source = "partialPurchase", target = "partialPurchase")
    @Mapping(source = "appartment", target = "appartment")
    @Mapping(source = "building", target = "building")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "streetName", target = "streetName")
    @Mapping(source = "streetNumber", target = "streetNumber")
    @Mapping(source = "townName", target = "townName")
    List<DeliveryPointDTO> toDTO (List<DeliveryPoint> deliveryPoint);
}
