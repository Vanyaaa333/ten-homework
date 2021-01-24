package AdditionalTask2;

import AdditionalTask2.WorkWithMenu.WorkWithConsoleMenu;
import AdditionalTask2.WorkWithProduct.WorkWithProduct;

public class DemoMain {

    public static void main(String[] args) {
        WorkWithConsoleMenu menu = new WorkWithConsoleMenu();
        WorkWithProduct products =new WorkWithProduct();
        menu.addMenu();
        menu.printMenuAndGetInputOfPerson();
    }
}
