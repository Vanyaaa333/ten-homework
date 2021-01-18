package AdditionalTask2;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Shop {

    List<Product> listOfProducts = new LinkedList<>();

    public boolean add(int id , int price , String name){
        Product product = new Product(id,price,name);
        for(Product prod : listOfProducts){
            if(product.getId() == prod.getId()) {
                System.out.println("Вы пытаетесь добавить продукт с уже существующим Id");
                return false;
            }
        }
        listOfProducts.add(product);
        return true;
    }

    public void printList(){
        listOfProducts.forEach(x -> System.out.println(x.toString()));
    }

    public List get(){
        return listOfProducts;
    }

    public boolean remove(int id) {
        for (Product temporaryProduct : listOfProducts) {
            if (temporaryProduct.getId() == id) {
                listOfProducts.remove(temporaryProduct);
                return true;
            }
        }
        return false;
    }


    public boolean redacted(int id , int newPrice ,String newName){
        for (Product temporaryProduct : listOfProducts) {
            if (temporaryProduct.getId() == id) {
                temporaryProduct.setName(newName);
                temporaryProduct.setPrice(newPrice);
                return true;
            }
        }
        return false;
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
