package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivan Ivanov");
        student.setGroup(7);
        student.setEnrollment(new Date());
        System.out.println(
                "Student: " + student.getFullName() +
                System.lineSeparator() +
                "Group: " + student.getGroup() +
                System.lineSeparator() +
                "Date of enrollment: " + student.getEnrollment()
        );
    }
}
