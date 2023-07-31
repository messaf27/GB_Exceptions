package Lesson_02;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        try {
            userInputString();
        }catch (Exception e){
            System.out.println(e);
        }

    }
    static void userInputString() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input string: ");
        if(in.nextLine().length() == 0){
            throw new RuntimeException("Input string length is 0 !!!");
        }
    }
}
