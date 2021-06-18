package ru.aignatkin.delivery.service;

import org.springframework.stereotype.Service;
import ru.aignatkin.delivery.dto.DeliveryPointDTO;
import ru.aignatkin.delivery.dto.DeliveryPointsDTO;
import ru.aignatkin.delivery.exception.DeliveryPointException;
import ru.aignatkin.delivery.mapper.DeliveryPointMapper;
import ru.aignatkin.delivery.model.DeliveryPoint;
import ru.aignatkin.delivery.repository.DeliveryPointsRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class DeliveryPointsServiceImpl implements DeliveryPointsService {
    private static Logger log = Logger.getLogger(DeliveryPointsServiceImpl.class.getName());

    private final DeliveryPointsRepository deliveryPointsRepository;
    private final DeliveryPointMapper deliveryPointMapper;

    public DeliveryPointsServiceImpl (DeliveryPointsRepository deliveryPointsRepository, DeliveryPointMapper deliveryPointMapper) {
        this.deliveryPointsRepository = deliveryPointsRepository;
        this.deliveryPointMapper = deliveryPointMapper;
    }

    @Override
    public DeliveryPointsDTO getAll () {
        List<DeliveryPoint> deliveryPointList = this.deliveryPointsRepository.findAll();

        if (deliveryPointList.isEmpty()) {
            return null;
        }

        List<DeliveryPointDTO> deliveryPointDTOList = new ArrayList<>();
        for (DeliveryPoint deliveryPoint : deliveryPointList) {
            DeliveryPointDTO deliveryPointDTO = deliveryPointMapper.toDTO(deliveryPoint);
            deliveryPointDTOList.add(deliveryPointDTO);
        }

        DeliveryPointsDTO deliveryPointsDTO = new DeliveryPointsDTO();
        deliveryPointsDTO.setDeliveryPoints(deliveryPointDTOList);

        return deliveryPointsDTO;
    }

    @Override
    public DeliveryPointsDTO getId (String name) throws DeliveryPointException {
        DeliveryPointsDTO deliveryPointsDTO = new DeliveryPointsDTO();
        List<DeliveryPointDTO> deliveryPointDTOList = new ArrayList<>();

        try {
            DeliveryPoint deliveryPoint = this.deliveryPointsRepository.getOne(name);
            deliveryPointDTOList.add(deliveryPointMapper.toDTO(deliveryPoint));
        } catch (EntityNotFoundException ex) {
            throw new DeliveryPointException("Delivery point \"" + name + "\" not found. " + ex);
        }

        deliveryPointsDTO.setDeliveryPoints(deliveryPointDTOList);

        return deliveryPointsDTO;
    }

    @Override
    public void save (DeliveryPointsDTO deliveryPointsDTO) throws DeliveryPointException {
        for (DeliveryPointDTO deliveryPointDTO : deliveryPointsDTO.getDeliveryPointDTO()) {

            if (deliveryPointDTO.getName().equals("")) {
                throw new DeliveryPointException("Field \"name\" mast have a value");
            }
            // .. other data checks

            DeliveryPoint deliveryPoint = deliveryPointMapper.fromDTO(deliveryPointDTO);

            this.deliveryPointsRepository.save(deliveryPoint);
        }
    }
}
