package ru.aignatkin.delivery.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.aignatkin.delivery.DeliveryApplication;
import ru.aignatkin.delivery.GsonParser;
import ru.aignatkin.delivery.dto.DeliveryPointDTO;
import ru.aignatkin.delivery.dto.DeliveryPointsDTO;
import ru.aignatkin.delivery.mapper.DeliveryPointMapper;
import ru.aignatkin.delivery.model.DeliveryPoint;
import ru.aignatkin.delivery.service.DeliveryPointsService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/delivery_points/")
public class DeliveryPointsRestController {
    private static Logger log = Logger.getLogger(DeliveryApplication.class.getName());

    @Autowired
    private DeliveryPointsService deliveryPointsService;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
    public ResponseEntity<DeliveryPointsDTO> saveDeliveryPoints (@RequestBody String jsonString) {
        log.info("POST request accepted");

        GsonParser parser = new GsonParser();
        DeliveryPointsDTO deliveryPointsDTO = parser.parse(jsonString);

        for (DeliveryPointDTO deliveryPointDTO : deliveryPointsDTO.getDeliveryPointDTO()) {

            deliveryPointDTO.initGet();
            DeliveryPoint deliveryPoint = DeliveryPointMapper.INSTANCE.fromDTO(deliveryPointDTO);

            if (deliveryPoint == null) {
                log.info("Can't parse request body");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            this.deliveryPointsService.save(deliveryPoint);
        }

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(deliveryPointsDTO, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeliveryPointsDTO> getAllDeliveryPoints () {
        log.info("GET all request accepted");

        List<DeliveryPoint> deliveryPointList = this.deliveryPointsService.getAll();

        if (deliveryPointList.isEmpty()) {
            log.info("No one delivery point is found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<DeliveryPointDTO> deliveryPointDTOList = DeliveryPointMapper.INSTANCE.toDTO(deliveryPointList);

        for (DeliveryPointDTO deliveryPointDTO : deliveryPointDTOList) {
            deliveryPointDTO.initSet();
        }

        DeliveryPointsDTO deliveryPointsDTO = new DeliveryPointsDTO();
        deliveryPointsDTO.setDeliveryPoints(deliveryPointDTOList);

        return new ResponseEntity<>(deliveryPointsDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeliveryPointsDTO> getDeliveryPoint (@PathVariable String id) {
        log.info("GET delivery point with name " + id);

        List<DeliveryPoint> deliveryPoint = this.deliveryPointsService.getId(id);

        if (deliveryPoint == null) {
            log.info("Delivery point " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<DeliveryPointDTO> deliveryPointDTOList = DeliveryPointMapper.INSTANCE.toDTO(deliveryPoint);

        for (DeliveryPointDTO deliveryPointDTO : deliveryPointDTOList) {
            deliveryPointDTO.initSet();
        }

        DeliveryPointsDTO deliveryPointsDTO = new DeliveryPointsDTO();
        deliveryPointsDTO.setDeliveryPoints(deliveryPointDTOList);

        return new ResponseEntity<>(deliveryPointsDTO, HttpStatus.OK);
    }
}

