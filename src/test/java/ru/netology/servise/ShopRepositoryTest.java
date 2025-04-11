package ru.netology.servise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repository = new ShopRepository();

    Product product1 = new Product(55, "Ромашка", 145);
    Product product2 = new Product(75, "Роза", 257);
    Product product3 = new Product(13, "Гвоздика", 128);

    @Test
    public void deletingAnElement (){
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        repository.removeById(75);

        Product[] expected = {product1, product3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deletingNonExistentElement (){
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);


        Assertions.assertThrows(NotFoundException.class, () -> {repository.removeById(88);});

        Product[] expected = {product1, product2, product3};
        Product [] actual = repository.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
}
