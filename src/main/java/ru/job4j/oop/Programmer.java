package ru.job4j.oop;

public class Programmer extends Engineer {

    private String language;

    public Programmer(String name, String surname, String education, String birthdate,
                      String language) {
        super(name, surname, education, birthdate);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

}
