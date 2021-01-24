package Task1;

import java.util.*;

public class FirstTask {

    public static void main(String[] arg) {
        WorkWithQueue queue = new WorkWithQueue();
        queue.push("1");
        queue.push("2");
        queue.push("3");
        System.out.println(queue.findObjectIndex("2"));
        /*
        *If method findObjectIndex return 0, your object didn't contains input element.
        */
        System.out.println("--------------");
        while (queue.size() > 0) {
            String s = (String) queue.pull();
            System.out.println(s);
            System.out.println("Размер очереди:" + queue.size());
        }

    }
}



