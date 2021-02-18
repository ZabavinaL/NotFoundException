package ru.netology.domain;

public class Product {
    private int id;
    private String nameProduct;
    private int priceProduct;

    public Product(int id, String nameProduct, int priceProduct) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public int getId() {
        return id;
    }

    public String getNameProduct() {
        return nameProduct;
    }
}