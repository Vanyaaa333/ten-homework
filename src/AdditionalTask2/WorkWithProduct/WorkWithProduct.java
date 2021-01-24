package AdditionalTask2.WorkWithProduct;

import AdditionalTask2.Product;
import AdditionalTask2.Shop;
import AdditionalTask2.WorkWithPersonInput.WorkWithConsolePersonInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class WorkWithProduct {

    private static Shop shop = new Shop();

    static Comparator<Product> comp = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return Double.compare(o1.getPrice(),o2.getPrice());
        }
    };

    public static void descendingPrice() {
        List newList = new ArrayList();
        newList.addAll(shop.get());
        Collections.sort(newList, comp.reversed());
        newList.forEach(x -> System.out.println(x.toString()));
    }

    public static void ascendingPrice() {
        List newList = new ArrayList();
        newList.addAll(shop.get());
        Collections.sort(newList, comp);
        newList.forEach(x -> System.out.println(x.toString()));
    }

    public static void toAdd() {
        Collections.reverse(shop.get());
        shop.printList();
    }

    public static void addProduct(){
        int id = WorkWithConsolePersonInput.getOtherIntValues("Введите Id товара");
        int price = WorkWithConsolePersonInput.getOtherIntValues("Введите цену товара");
        String name = WorkWithConsolePersonInput.getStringValues("Введите название товара");
        if(shop.add(id,price,name)) {
            System.out.println("товара успешно добавлен в список");
        }
    }

    public static void deleteProduct(){
        int id = WorkWithConsolePersonInput.getOtherIntValues("Введите Id товара для удаления");
        if(shop.remove(id)){
            System.out.println("Товар успешно удален");
        }
        else{
            System.out.println("Вы ввели Id несуществующего товара");
        }
    }

    public static void redactedProduct(){
        int id = WorkWithConsolePersonInput.getOtherIntValues("Введите Id товара");
        int newPrice = WorkWithConsolePersonInput.getOtherIntValues("Введите новую цену товара");
        String newName = WorkWithConsolePersonInput.getStringValues("Введите новое название товара");
        if(shop.redacted(id,newPrice,newName)){
            System.out.println("Товар успешно изменен");
        }
        else{
            System.out.println("Вы ввели Id несуществующего товара");
        }
    }

}
