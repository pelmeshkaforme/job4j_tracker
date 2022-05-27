package ru.job4j.pojo;

import java.util.Date;

public class Police {
    public static void main(String[] args) {
        License license = new License();
        license.setModel("Toyota");
        license.setOwner("Petr");
        license.setCode("xx123x");
        license.setCreated(new Date());

        System.out.println(license.getOwner() + " has a car " + license.getModel() + " with code " + license.getCode());
    }
}
