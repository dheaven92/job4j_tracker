package ru.job4j.poly;

public class VehicleApp {

    public static void main(String[] args) {
        Vehicle plain = new Plain();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] vehicles = new Vehicle[]{plain, train, bus};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.getFuelType();
            System.out.println("================================");
        }
    }
}
