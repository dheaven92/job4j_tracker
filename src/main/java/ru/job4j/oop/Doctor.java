package ru.job4j.oop;

public class Doctor extends Profession {

    public Doctor(String name, String surname, String education, String birthdate) {
        super(name, surname, education, birthdate);
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }
}
