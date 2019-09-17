package pl.javastart.products.repository;

import org.springframework.stereotype.Repository;
import pl.javastart.products.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsRepository {
    private List<Product> productList;

    public ProductsRepository() {
        this.productList = new ArrayList<>();
        productList.add(new Product("Mleko", 2.49));
        productList.add(new Product("Makaron", 3.69));
        productList.add(new Product("Czajnik", 99.99));
        productList.add(new Product("Toster", 66));
        productList.add(new Product("Blok rysunkowy", 3));
        productList.add(new Product("Linijka", 2));
    }

    public List<Product> getAll() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
}
