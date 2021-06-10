package ru.aignatkin.delivery.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.aignatkin.delivery.model.DeliveryPoints;
import ru.aignatkin.delivery.service.DeliveryPointsService;

@RestController
@RequestMapping("/api/v1/delivery_points/")
public class DeliveryPointsRestController {

    @Autowired
    private DeliveryPointsService deliveryPointsService;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeliveryPoints> saveDeliveryPoints (@RequestBody DeliveryPoints deliveryPoints) {
        HttpHeaders headers = new HttpHeaders();
        System.out.println("Request! " + deliveryPoints.displayName);

        if (deliveryPoints == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.deliveryPointsService.save(deliveryPoints);

        return new ResponseEntity<>(deliveryPoints, headers, HttpStatus.CREATED);
    }
}

