package AdditionalTask2.WorkWithPersonInput;

import java.util.Scanner;

public class WorkWithConsolePersonInput {

    private static Scanner sc = new Scanner(System.in);

    public static int getOtherIntValues() {
        if(sc.hasNextInt()) {
            return sc.nextInt();
        }
        System.out.println(String.format("Ввод [%s] не является числом. Повторите ввод.", sc.next()));
        return getOtherIntValues();
    }

    public static int getOtherIntValues(String massage) {
        System.out.println(massage);
        return getOtherIntValues();
    }

    public static String getStringValues() {
        Scanner sc1 = new Scanner(System.in);
        String input = sc1.nextLine();
        if (input.isBlank()) {
            System.out.println("Введена пустая строка. Повторите ввод.");
            getStringValues();
        }
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isLetter(input.charAt(i))){
                System.out.println("Введена цифра или пробел. Повторите ввод.");
                input = "";
                getStringValues();
            }
        }
        return input;
    }
    public static String getStringValues(String message) {
        System.out.println(message);
        return getStringValues();
    }

}
