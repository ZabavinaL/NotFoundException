package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.TShirt;

import org.junit.jupiter.api.Test;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Book bookThird = new Book(1, "Pride and Prejudice", 100, "Jane Austen");
    private Book bookSecond = new Book(2, "The Wonderful Wizard of Oz", 130, "Lyman Frank Baum");
    private TShirt shirtSecond = new TShirt(3, "T-Shirt Car", 15, "White", "M");
    private TShirt shirtThird = new TShirt(4, "T-Shirt Flower", 11, "Blue", "S");

    @BeforeEach
    public void setUp() {
        repository.save(bookThird);
        repository.save(bookSecond);
        repository.save(shirtSecond);
        repository.save(shirtThird);
    }

    @Test
    public void shouldRemoveById() {
        Product[] actual = repository.removeById(3);
        Product[] expected = new Product[]{bookThird, bookSecond, shirtThird};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdNotFoundException() {
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }
}