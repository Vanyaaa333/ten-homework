package Task2;

import java.util.*;

public class Shop{

    List <Product> listOfProducts = new LinkedList<>();

    void add(Product product){
        for(Product prod : listOfProducts){
            if(product.getId() == prod.getId()){
                System.out.println("Вы пытаетесь добавить продукт с уже существующим Id");
                return;
            }
        }
        listOfProducts.add(product);
    }

    void printList(){
        listOfProducts.forEach(x -> System.out.println(x.toString()));
    }

    List get(){
        return listOfProducts;
    }

    void remove(Product product){
        for(Product temporaryProduct:listOfProducts){
            if(temporaryProduct.equals(product)){
                listOfProducts.remove(product);
                return;
            }
        }
    }
    void redacted(Product product , int price ,int id , String name){
        product.setId(id);
        product.setPrice(price);
        product.setName(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(listOfProducts, shop.listOfProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfProducts);
    }
}
