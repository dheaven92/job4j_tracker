package ru.job4j.oop;

public class Profession {

    private String name;

    private String surname;

    private String education;

    private String birthdate;

    public Profession(String name, String surname, String education, String birthdate) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthdate() {
        return birthdate;
    }
}
