package ru.job4j.ooa;

public final class Airbus extends Aircraft {

    private static final int COUNT_ENGINE = 2;

    private static final String AIRBUS_A380 = "A380";

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        int countEngine = AIRBUS_A380.equals(this.name) ? 4 : COUNT_ENGINE;
        System.out.println("Количество двигателей равно: " + countEngine);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
