package ru.job4j.poly;

public class Bus2 implements Transport {

    private int passengers;
    private double fuelCostPerGallon = 2.5;
    
    @Override
    public void drive() {
        System.out.println("drives on roads");
    }

    @Override
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public double setFuel(int gallons) {
        return gallons * fuelCostPerGallon;
    }
}
