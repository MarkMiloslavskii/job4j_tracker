package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Движется по дороге");
    }

    @Override
    public int cost() {
        return 10;
    }
}
