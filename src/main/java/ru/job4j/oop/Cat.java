package ru.job4j.oop;

public class Cat {

    private String name;
    private String food;

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.print(this.name);
        System.out.println(this.food);
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("Гав ");
        gav.eat("cutlet");
        gav.show();

        Cat black = new Cat();
        black.giveNick("Черныш ");
        black.eat("fish");
        black.show();
    }
}