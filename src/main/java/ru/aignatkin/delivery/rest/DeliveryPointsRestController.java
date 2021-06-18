package ru.aignatkin.delivery.rest;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.aignatkin.delivery.dto.DeliveryPointsDTO;
import ru.aignatkin.delivery.exception.DeliveryPointException;
import ru.aignatkin.delivery.mapper.DeliveryPointMapper;
import ru.aignatkin.delivery.service.DeliveryPointsService;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/delivery_points/")
public class DeliveryPointsRestController {
    private static Logger log = Logger.getLogger(DeliveryPointsRestController.class.getName());

    private final DeliveryPointsService deliveryPointsService;
    private final DeliveryPointMapper deliveryPointMapper;

    public DeliveryPointsRestController(DeliveryPointsService deliveryPointsService, DeliveryPointMapper deliveryPointMapper) {
        this.deliveryPointsService = deliveryPointsService;
        this.deliveryPointMapper = deliveryPointMapper;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeliveryPointsDTO> saveDeliveryPoints (@RequestBody DeliveryPointsDTO deliveryPointsDTO) {
        log.info("POST request accepted");

        try {
            deliveryPointsService.save(deliveryPointsDTO);
        } catch (DeliveryPointException ex) {
            log.info("POST request incorrect data: " + ex);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        log.info("POST request processed");

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(deliveryPointsDTO, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeliveryPointsDTO> getAllDeliveryPoints ()  {
        log.info("GET all request accepted");

        DeliveryPointsDTO deliveryPointsDTO = this.deliveryPointsService.getAll();

        if (deliveryPointsDTO == null) {
            log.info("GET all request: no one delivery point is found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            log.info("GET all request processed");
            return new ResponseEntity<>(deliveryPointsDTO, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeliveryPointsDTO> getDeliveryPoint (@PathVariable String id) {
        log.info("GET delivery point with name " + id);

        try {
            DeliveryPointsDTO deliveryPointsDTO = this.deliveryPointsService.getId(id);

            log.info("GET delivery point " + id + " processed");
            return new ResponseEntity<>(deliveryPointsDTO, HttpStatus.OK);

        } catch (DeliveryPointException ex) {
            log.info("GET request: " + ex);
            //log.info("Delivery point " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}

