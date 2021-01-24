package AdditionalTask2.WorkWithMenu;

import AdditionalTask2.WorkWithPersonInput.WorkWithConsolePersonInput;
import AdditionalTask2.WorkWithProduct.WorkWithProduct;

import java.util.*;

public class WorkWithConsoleMenu {

    static Map<Integer, String> menu = new TreeMap<Integer, String>();


    public void addMenu() {
        menu.put(1, "Вывод всех товаров");
        menu.put(2, "Добавление товара");
        menu.put(3, "Удаление товара");
        menu.put(4, "Редактирование товара");
        menu.put(5, "Выход");
    }

    public void printMenu() {
        for (Map.Entry<Integer, String> menuItem : menu.entrySet()) {
            System.out.printf("%s.%s\n", menuItem.getKey(), menuItem.getValue());
        }
    }

    public int printMenuAndGetInputOfPerson() {
        printMenu();
        int personInput = WorkWithConsolePersonInput.getOtherIntValues();
        if (personInput <=5 && personInput > 0) {
            if (personInput == 1) {
                firstMenuItem();
                printMenuAndGetInputOfPerson();
            } else if (personInput == 2) {
                WorkWithProduct.addProduct();
                printMenuAndGetInputOfPerson();
            } else if (personInput == 3) {
                WorkWithProduct.deleteProduct();
                printMenuAndGetInputOfPerson();
            } else if (personInput == 4) {
                WorkWithProduct.redactedProduct();
                printMenuAndGetInputOfPerson();
            } else if (personInput == 5) {
                return 0;
            }
        }
        else {
            System.out.println("Вы выбрали несуществующую команду.Повторите ввод.");
            return printMenuAndGetInputOfPerson();
        }
        return 0;
    }


    public int firstMenuItem() {
        int personInput = WorkWithConsolePersonInput.getOtherIntValues("Какая сортировка списика вам потребуется :\n1)По Возрастанию цены" +
                "\n2)По убыванию цены" +
                "\n3)По добавлению(сначала новые)");
        if(personInput<4 && personInput>0) {
            if (personInput == 1) {
                WorkWithProduct.ascendingPrice();
            } else if (personInput == 2) {
                WorkWithProduct.descendingPrice();
            } else if (personInput == 3) {
                WorkWithProduct.toAdd();
            }
            return 0;
        }
        System.out.println("Вы выбрали несуществующую сортировку.Повторите ввод.");
        return firstMenuItem();
    }
}


