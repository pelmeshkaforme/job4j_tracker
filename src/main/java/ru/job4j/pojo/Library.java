package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book pushkin = new Book("Pushkin", 500);
        Book vocabulary = new Book("Vocabulary", 1000);
        Book cleanCode = new Book("Clean code", 300);
        Book threeLittlePigs = new Book("Three little pigs", 10);
        Book[] books = {pushkin, vocabulary, cleanCode, threeLittlePigs};
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println("Книга " + book.getName() + " имеет страниц - " +  book.getPageQty());
        }
        System.out.println();
        System.out.println("После размена местами книг с индексами 0 и 3.");
        Book temp = new Book(books[0].getName(), books[0].getPageQty());
        books[0] = temp;
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println("Книга " + book.getName() + " имеет страниц - " +  book.getPageQty());
        }
        System.out.println();
        System.out.println("Выводим книги с названием Clean code");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if ("Clean code".equals(book.getName())) {
                System.out.println("Книга с индексом " +  i + " имеет название Clean code");
            }
        }
    }
}
