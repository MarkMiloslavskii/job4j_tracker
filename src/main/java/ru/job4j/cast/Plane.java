package ru.job4j.cast;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Летит");
    }

    @Override
    public int cost() {
        return 100;
    }
}
