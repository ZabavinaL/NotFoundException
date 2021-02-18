
package ru.netology.domain;

import java.util.Objects;

public class TShirt extends Product {
    private String color;
    private String size;

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public TShirt(int id, String nameProduct, int priceProduct, String color, String size) {
        super(id, nameProduct, priceProduct);
        this.color = color;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TShirt shirt = (TShirt) o;
        return Objects.equals(color, shirt.color) &&
                Objects.equals(size, shirt.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, size);
    }
}