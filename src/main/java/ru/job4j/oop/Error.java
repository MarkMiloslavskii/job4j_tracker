package ru.job4j.oop;

public class Error {

    private  boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public void printInfo() {
        System.out.print(active + " ");
        System.out.print(status + " ");
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error = new Error(true, 1, "A");
        error.printInfo();
        Error erro = new Error(false, 2, "B");
        erro.printInfo();
        Error err = new Error(true, 3, "C");
        err.printInfo();
        Error er = new Error();
        er.printInfo();
    }
}
