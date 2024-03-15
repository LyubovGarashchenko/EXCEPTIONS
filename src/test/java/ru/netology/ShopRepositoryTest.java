package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void shouldTestRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "фен", 1_000);
        Product product2 = new Product(11, "холодильник", 15_000);
        Product product3 = new Product(12, "телевизор", 10_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(12);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTestRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "фен", 1_000);
        Product product2 = new Product(11, "холодильник", 15_000);
        Product product3 = new Product(12, "телевизор", 10_000);

        repo.add(product1);
        repo.add(product1);
        repo.add(product1);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(13));
    }
}
