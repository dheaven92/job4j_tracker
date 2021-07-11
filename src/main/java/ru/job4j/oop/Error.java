package ru.job4j.oop;

public class Error {

    private boolean active;

    private int status;

    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void showDetails() {
        System.out.println("active: " + this.active + "; status: " + this.status
                + "; message: " + this.message);
    }

    public static void main(String[] args) {
        Error unknownError = new Error();
        unknownError.showDetails();
        Error clientError = new Error(true, 400, "Bad request");
        clientError.showDetails();
        Error serverError = new Error(true, 500, "Internal server error");
        serverError.showDetails();
    }
}
