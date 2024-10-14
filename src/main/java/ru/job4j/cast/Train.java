package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Движется по рельсам");
    }

    @Override
    public int cost() {
        return 50;
    }
}