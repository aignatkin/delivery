package ru.aignatkin.delivery.coordinate;

import org.springframework.stereotype.Service;

import static java.lang.Math.*;

@Service
public class Coordinate {
    public Double getDistance (float coordinate_w1, float coordinate_l1, float coordinate_w2, float coordinate_l2) {
        final double R=6371;
        float p = 0.017453292519943295f;
        return R * 2 * asin(sqrt(0.5 - cos((coordinate_w2 - coordinate_w1)*p)/2 + cos(coordinate_w1*p) * cos(coordinate_w2*p) * (1 - cos((coordinate_l2 - coordinate_l1)*p))/2));
    }
}
