package ru.job4j.oop;

public class Engineer extends Profession {

    public Engineer(String name, String surname, String education, String birthdate) {
        super(name, surname, education, birthdate);
    }

    public Solution canFollowAlgorithmToGetSolution(Algorithm algorithm) {
        return new Solution();
    }
}
