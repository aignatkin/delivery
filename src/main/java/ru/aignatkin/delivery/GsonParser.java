package ru.aignatkin.delivery;

import com.google.gson.Gson;
import ru.aignatkin.delivery.dto.DeliveryPointsDTO;

public class GsonParser {

    public DeliveryPointsDTO parse(String jsonString) {
        Gson gson = new Gson();
        DeliveryPointsDTO deliveryPointsDTO = gson.fromJson(jsonString, DeliveryPointsDTO.class);

        return deliveryPointsDTO;
    }
}
