package org.example;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int getValidInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Ошибка. Введите целое число: ");
            scanner.next(); // пропустить неправильный ввод
        }
        return scanner.nextInt();
    }
    public static void main(String[] args) {
        int numb1;
        int numb2;
        int numb3;
        int numb4;
        int numb5;
        ShapeChecker checker = new ShapeChecker();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сторона 1/ Радіус: ");
        numb1 = getValidInt(scanner);

        System.out.print("Сторона 2: ");
        numb2 = getValidInt(scanner);

        System.out.print("Сторона 3: ");
        numb3 = getValidInt(scanner);

        System.out.print("Сторона 4: ");
        numb4 = getValidInt(scanner);

        System.out.print("Сторона 5: ");
        numb5 = getValidInt(scanner);
        checker.setSides( numb1, numb2, numb3, numb4, numb5);
        String result = checker.Detect();
        System.out.println("Определённая фигура: " + result);

    }
}