import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product_1 = new Product(1, "хлеб", 50);
    Product product_2 = new Product(2, "масло", 150);
    Product product_3 = new Product(3, "мясо", 770);

    @Test
    public void shouldAddProduct() {
        ShopRepository repo = new ShopRepository();
        repo.add(product_1);
        repo.add(product_2);
        repo.add(product_3);
        Product[] expected = {product_1, product_2, product_3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveProduct() {
        ShopRepository repo = new ShopRepository();
        repo.add(product_1);
        repo.add(product_2);
        repo.add(product_3);
        repo.removeById(2);
        Product[] expected = {product_1, product_3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow_NotFoundException() {
        ShopRepository repo = new ShopRepository();
        repo.add(product_1);
        repo.add(product_2);
        repo.add(product_3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(7);
        });
    }
}
