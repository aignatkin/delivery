package ru.aignatkin.delivery.coordinate;

import org.springframework.stereotype.Service;

import static java.lang.Math.*;

@Service
public class Coordinate {
    //TODO: можно было сделать статический метод

    //TODO: зачем каждый раз в методе объявлять? вынести в константу класса
    private final double R=6371;

    //
    private final float P = 0.017453292519943295f;

    public Double getDistance (float coordinate_w1, float coordinate_l1, float coordinate_w2, float coordinate_l2) {


        //TODO: что за формула? в комментах написать
        return R * 2 * asin(sqrt(0.5 - cos((coordinate_w2 - coordinate_w1)* P)/2 + cos(coordinate_w1* P) * cos(coordinate_w2* P) * (1 - cos((coordinate_l2 - coordinate_l1)* P))/2));
    }
}
