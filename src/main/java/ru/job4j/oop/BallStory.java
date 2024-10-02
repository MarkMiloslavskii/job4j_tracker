package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
    Hare white = new Hare();
    Wolf grey = new Wolf();
    Fox orange = new Fox();
    Ball ball = new Ball();

    white.tryEat(ball);
    grey.tryEat(ball);
    orange.tryEat(ball);
    }
}
