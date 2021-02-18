package ru.netology.domain;

public class Book extends Product {
    private String author;


    public Book(int id, String nameProduct, int priceProduct, String author) {
        super(id, nameProduct, priceProduct);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}