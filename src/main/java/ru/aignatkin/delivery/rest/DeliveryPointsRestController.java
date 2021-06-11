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

import java.util.List;

@RestController
@RequestMapping("/api/v1/delivery_points/")
public class DeliveryPointsRestController {

    @Autowired
    private DeliveryPointsService deliveryPointsService;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeliveryPoints> saveDeliveryPoints (@RequestBody DeliveryPoints deliveryPoints) {
        System.out.println("Request to POST! " + deliveryPoints.displayName);

        HttpHeaders headers = new HttpHeaders();
        if (deliveryPoints == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.deliveryPointsService.save(deliveryPoints);

        return new ResponseEntity<>(deliveryPoints, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DeliveryPoints>> getAllDeliveryPoints () {
        System.out.println("Request to GET ALL!");

        HttpHeaders headers = new HttpHeaders();
        List<DeliveryPoints> deliveryPoints = this.deliveryPointsService.getAll();
        if (deliveryPoints.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        for(DeliveryPoints dp : deliveryPoints){
            System.out.println(dp.getName());
        }

        return new ResponseEntity<>(deliveryPoints, HttpStatus.OK);
    }
}

