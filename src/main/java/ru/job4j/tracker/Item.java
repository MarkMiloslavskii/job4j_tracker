package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item() {
    }

    public void printInfo() {
        System.out.print(id + " ");
        System.out.println(name);
    }

    public static void main(String[] args) {
        Item a = new Item();
        a.printInfo();
        Item b = new Item(10, "Alpha");
        b.printInfo();
        Item c = new Item("Beta");
        c.printInfo();
    }
}