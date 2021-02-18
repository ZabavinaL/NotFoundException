package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.TShirt;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book bookFirst = new Book(1, "Pride and Prejudice", 100, "Jane Austen");
    private Book bookSecond = new Book(2, "The Wonderful Wizard of Oz", 130, "Lyman Frank Baum");
    private Book bookThird = new Book(3, "The Adventures of Tom Sawyer", 155, "Mark Twain");
    private TShirt shirtFirst = new TShirt(4, "T-Shirt Flower", 12, "Red", "XL");
    private TShirt shirtSecond = new TShirt(5, "T-Shirt Car", 15, "White", "M");
    private TShirt shirtThird = new TShirt(6, "T-Shirt Flower", 11, "Blue", "S");

    @BeforeEach
    public void setUp() {
        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(shirtFirst);
        manager.add(shirtSecond);
        manager.add(shirtThird);
    }

    @Test
    public void shouldGetAll() {
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{bookFirst, bookSecond, bookThird, shirtFirst, shirtSecond, shirtThird};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBypNameProductBook() {
        Product[] actual = manager.searchBy("The Wonderful Wizard of Oz");
        Product[] expected = new Book[]{bookSecond};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] actual = manager.searchBy("Mark Twain");
        Product[] expected = new Book[]{bookThird};
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByColorTShirt() {
        Product[] actual = manager.searchBy("Red");
        Product[] expected = new TShirt[]{shirtFirst};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySize() {
        Product[] actual = manager.searchBy("S");
        Product[] expected = new TShirt[]{shirtThird};
        assertArrayEquals(expected, actual);
    }

}