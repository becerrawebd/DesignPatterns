package org.designpatterns;

import org.designpatterns.car.Car;
import org.designpatterns.car.Color;
import org.designpatterns.car.Engine;

public class Main {
    public static void main(String[] args) {
        Car car = Car
                .getBuilder()
                .withDoors(4)
                .withColor(Color.BLUE)
                .withEngine(new Engine(6,true))
                .build();
        System.out.println(car);
    }
}