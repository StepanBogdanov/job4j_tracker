package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book[] library = new Book[4];
        Book cleanCode = new Book("Clean Code", 250);
        Book hobbit = new Book("Hobbit", 150);
        Book chemistry = new Book("Chemistry", 300);
        Book seaBattle = new Book("seaBattle", 200);
        library[0] = cleanCode;
        library[1] = hobbit;
        library[2] = chemistry;
        library[3] = seaBattle;
        for (int index = 0; index < library.length; index++) {
            Book book = library[index];
            System.out.println(book.getName() + ": " + book.getPages() + " pages");
        }
        System.out.println();
        Book temp = library[0];
        library[0] = library[3];
        library[3] = temp;
        for (int index = 0; index < library.length; index++) {
            Book book = library[index];
            System.out.println(book.getName() + ": " + book.getPages() + " pages");
        }
        System.out.println();
        for (int index = 0; index < library.length; index++) {
            Book book = library[index];
            if (book.getName().equals("Clean Code")) {
                System.out.println(book.getName() + ": " + book.getPages() + " pages");
            }
        }
    }
}
