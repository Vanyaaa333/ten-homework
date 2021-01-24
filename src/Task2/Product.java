package Task2;

import java.util.Objects;

public class Product {

    private int id;
    private int price;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(int id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", price=" + price +
                ", name=" + name;
    }



}
