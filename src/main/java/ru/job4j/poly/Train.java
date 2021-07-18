package ru.job4j.poly;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println("travels by rail");
    }

    @Override
    public void getFuelType() {
        System.out.println("diesel");
    }
}
