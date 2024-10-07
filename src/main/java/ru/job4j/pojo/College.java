package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivanov Ivan Ivanovich");
        student.setGroup(1);
        student.setStarted("01.01.2021");
        System.out.println(student.getName() + " from the group №" + student.getGroup()
                + " started his studies in " + student.getStarted());
    }
}
