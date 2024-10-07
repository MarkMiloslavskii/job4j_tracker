package ru.job4j.pojo;

public class Library {

    public int[] swapBorder(int[] books) {
        int temp = books[1];
        books[1] = books[3];
        books[3] = temp;
        return books;
    }

    public static void main(String[] args) {
        Book buratino = new Book("Buratino", 100);
        Book carlson = new Book("Carlson", 200);
        Book winniePooh = new Book("WinniePooh", 300);
        Book hercules = new Book("Hercules", 400);
        Book cleancode = new Book("Clean code", 0);
        Book[] books = new Book[5];
        books[0] = buratino;
        books[1] = carlson;
        books[2] = winniePooh;
        books[3] = hercules;
        books[4] = cleancode;

        for (Book tale : books) {
            System.out.println(tale.getName() + "," + tale.getPages());
        }

        System.out.println("Books with name: Clean code");
        for (Book tale : books) {
            if (tale == cleancode) {
                System.out.println(tale.getName() + "," + tale.getPages());
            }
        }
    }
}
