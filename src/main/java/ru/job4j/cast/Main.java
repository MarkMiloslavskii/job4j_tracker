package ru.job4j.cast;

public class Main {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] vehicles = new Vehicle[] {plane, train, bus};
        for (Vehicle i : vehicles) {
            i.move();
            System.out.println("Cтоит " + i.cost() + " у.е.");
        }
    }
}
