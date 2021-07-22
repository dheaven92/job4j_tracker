package ru.job4j.ooa;

public final class Airbus extends Aircraft {

    private static final int COUNT_ENGINE = 2;

    private String name;

    private int countEngine = COUNT_ENGINE;

    public Airbus(String name) {
        this.name = name;
    }

    public Airbus(String name, int countEngine) {
        this.name = name;
        this.countEngine = countEngine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountEngine() {
        return countEngine;
    }

    public void setCountEngine(int countEngine) {
        this.countEngine = countEngine;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        System.out.println("Количество двигателей равно: " + countEngine);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + "',"
                + "countEngine='" + countEngine + '\''
                + '}';
    }
}
