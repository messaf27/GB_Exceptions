package Lesson_02;

import java.io.FileNotFoundException;

public class Task3 {
    public static void main(String[] args) {
//        int [] intArray = {1,2,3,4,5,6,7,8,9};
//        try {
//            int d = 0;
//            double catchedRes1 = intArray[8] / d;
//            System.out.println("catchedRes1 = " + catchedRes1);
//        } catch (ArithmeticException e) {
//            System.out.println("Catching exception: " + e);
//        }

        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;

        } catch (NullPointerException ex) {
            System.out.println(" null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("array!");
        } catch (Throwable ex) {
            System.out.println("HZ");
        }
    }
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }
}

