package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 464);
        Book book2 = new Book("Book 2", 1200);
        Book book3 = new Book("Book 3", 770);
        Book book4 = new Book("Book 4", 300);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (Book book : books) {
            System.out.println(book.getName() + ' ' + book.getPageCount());
        }
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (Book book : books) {
            System.out.println(book.getName() + ' ' + book.getPageCount());
        }
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + ' ' + book.getPageCount());
            }
        }
    }
}
