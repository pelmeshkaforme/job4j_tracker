package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullname("John MсСlane");
        student.setGroup(205);
        student.setJoinDate("10.10.2020");
        System.out.println("Студент " + student.getFullname() + " из группы "
                + student.getGroup() + " поступил " + student.getJoinDate());
    }
}
