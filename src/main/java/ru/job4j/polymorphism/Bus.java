package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("После нажатия на педаль, транспорт начнет движение");
    }

    @Override
    public void passengers(int count) {
        int capasity = count * 3;
    }

    @Override
    public int refuel(int fuel) {
        int tank = 60;
        return tank - fuel;
    }
}
