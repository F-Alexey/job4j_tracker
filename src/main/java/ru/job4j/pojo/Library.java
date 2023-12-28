package ru.job4j.pojo;

public class Library {
    public static void print(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getPageCount());
        }
        System.out.println();
    }

    public static Book[] changeByIndex(int first, int second, Book[] books) {
        Book temp = books[first];
        books[first] = books[second];
        books[second] = temp;
        return books;
    }

    public static void main(String[] args) {
        Book first = new Book("Java for beginners", 361);
        Book second = new Book("Java advanced", 270);
        Book third = new Book("Clean code", 540);
        Book fourth = new Book("Algorithm and Data", 250);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;
        print(books);
        print(changeByIndex(0, 3, books));
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getPageCount());
            }
        }
    }
}
