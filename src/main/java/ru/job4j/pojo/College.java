package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Fedoseev A.K");
        student.setGroup("14B");
        student.setDate("27.12.2023");
        student.print();
    }
}
