package ru.job4j.pojo;

public class Book {
    private String name;
    private int pageQty;

    public Book() {

    }

    public Book(String name, int pageQty) {
        this.name = name;
        this.pageQty = pageQty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageQty() {
        return pageQty;
    }

    public void setPageQty(int pageQty) {
        this.pageQty = pageQty;
    }
}
