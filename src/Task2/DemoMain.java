package Task2;

import java.util.*;

public class DemoMain {

    public static void main(String[] args) {
        Shop shop1 = new Shop();
        Product product1 = new Product(1, 18, "Tea");
        shop1.add(new Product(2, 25, "Apple"));
        shop1.add(product1);
        shop1.add(new Product(3, 48, "Coffee"));
        shop1.add(new Product(4, 75, "Toy"));

        Comparator<Product> comp = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(),o2.getPrice());
            }
        };

        shop1.printList();
        System.out.println("---------------");

        Collections.reverse(shop1.get());
        shop1.printList();
        System.out.println("----------------");

        shop1.remove(2);
        shop1.printList();
        System.out.println("-----------------");

        Collections.sort(shop1.get(),comp);
        shop1.printList();
        System.out.println("------------------");

        shop1.redacted(product1,20,1,"TeaBlack");
        shop1.printList();

    }
}

