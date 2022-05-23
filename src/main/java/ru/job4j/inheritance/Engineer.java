package ru.job4j.inheritance;

import ru.job4j.inheritance.Profession;

public class Engineer extends Profession {
    private int experience;

    public Engineer(int experience, boolean degree) {
        super(degree);
        this.experience = experience;
    }
}
