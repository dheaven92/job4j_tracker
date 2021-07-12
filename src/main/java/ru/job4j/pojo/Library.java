package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Clean code");
        Book book2 = new Book("Book 2");
        Book book3 = new Book("Book 3");
        Book book4 = new Book("Book 4");
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (Book book : books) {
            System.out.println(book.getName());
        }
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        System.out.println();
        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName());
            }
        }
    }
}
