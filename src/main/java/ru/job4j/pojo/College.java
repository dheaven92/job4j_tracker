package ru.job4j.pojo;

import java.time.LocalDate;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Ivan");
        student.setMiddleName("Ivanovich");
        student.setLastName("Ivanov");
        student.setGroup(10);
        student.setEnrollmentDate(LocalDate.of(2020, 9, 1));
        System.out.println(student.getFirstName() + " " + student.getMiddleName() + " "
                + student.getLastName());
        System.out.println("Group: " + student.getGroup());
        System.out.println("Enrolled at: " + student.getEnrollmentDate());
    }
}
