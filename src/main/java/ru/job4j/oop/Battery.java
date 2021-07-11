package ru.job4j.oop;

public class Battery {

    private int energy;

    public Battery(int energy) {
        this.energy = energy;
    }

    public void exchange(Battery another) {
        another.energy = another.energy + this.energy;
        this.energy = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(1000);
        Battery second = new Battery(2000);
        System.out.println("first: " + first.energy + "; second: " + second.energy);
        first.exchange(second);
        System.out.println("first: " + first.energy + "; second: " + second.energy);
    }
}
