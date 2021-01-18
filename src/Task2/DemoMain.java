package Task2;

import java.util.*;

public class DemoMain {

    public static void main(String[] args) {
        Shop shop1 = new Shop();
        Product product1 = new Product(2, 30, "Tea");
        shop1.add(new Product(1, 35, "Apple"));
        shop1.add(product1);
        shop1.add(new Product(3, 48, "Coffee"));
        shop1.add(new Product(4, 40, "Toy"));

        Comparator<Product> comp = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(),o2.getPrice());
            }
        };

        shop1.printList();
        System.out.println("---------------");

        List newList = new ArrayList();
        newList.addAll(shop1.get());
        Collections.sort(newList,comp);
        newList.forEach(x-> System.out.println(x.toString()));
        System.out.println("------------------");

        Collections.reverse(shop1.get());
        shop1.printList();
        System.out.println("----------------");

        shop1.remove(new Product(2, 25, "Apple"));
        shop1.printList();
        System.out.println("-----------------");

        shop1.redacted(product1,20,1,"TeaBlack");
        shop1.printList();

    }
}

