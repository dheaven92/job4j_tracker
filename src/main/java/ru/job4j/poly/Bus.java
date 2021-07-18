package ru.job4j.poly;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("drives on roads");
    }

    @Override
    public void getFuelType() {
        System.out.println("gasoline");
    }
}
