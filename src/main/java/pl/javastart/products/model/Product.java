package pl.javastart.products.model;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        checkPreconditions(name, price);
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private void checkPreconditions(String name, double price) {
        if (name == null) {
            throw new NullPointerException("Podaj nazwę produktu");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Nazwa musi składać się z minimum trzech znaków");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Cena produktu musi być dodatnia");
        }
    }
}
