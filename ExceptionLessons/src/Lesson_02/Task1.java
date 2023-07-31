package Lesson_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        UserGetFloat();
    }
    static void UserGetFloat() {
        Scanner in = new Scanner(System.in);;
        System.out.print("Input float: ");
        try {
            float inFloat = in.nextFloat();
        }catch (InputMismatchException e){
            System.out.println("Incorrectly entered data is not a float type!!!");
        }

    }
}
