package Sem2;

import java.util.Scanner;

public class HW {

    public static void main(String[] args) {

        inputingString();
    }

    //task 1
    static float inputFloat(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input float number with ',' here: ");
        while (!scanner.hasNextFloat()){
            System.out.println("Incorrect. Try again");
            scanner.next();
        }
        float number = scanner.nextFloat();
        scanner.close();
        return number;
    }

    //task 2
    public static void task2(){
        int[] intArray = new int[10];
        intArray[8] = 10;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input int number here: ");
            int d = scanner.nextInt();
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }

    //task 3
//    public static void main(String[] args) throws Exception {
//        try {
//            int a = 90;
//            int b = 3;
//            System.out.println(a / b);
//            printSum(23, 234);
//            int[] abc = { 1, 2 };
//            abc[3] = 9;
//        } catch (NullPointerException ex) {
//            System.out.println("Указатель не может указывать на null!");
//        } catch (IndexOutOfBoundsException ex) {
//            System.out.println("Массив выходит за пределы своего размера!");
//        }catch (Throwable ex) {
//            System.out.println("Что-то пошло не так...");
//        }
//    }
//    public static void printSum(Integer a, Integer b) throws Exception {
//        System.out.println(a + b);
//    }

    //task 4

    public static String inputingString() throws IllegalStateException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string here: ");
        String input = scanner.nextLine();
        scanner.close();
        if (input.isEmpty()){
            throw new IllegalStateException("Not null string, please");
        }
        return input;
    }

}
