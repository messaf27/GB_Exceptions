package Lesson_01;

/*
Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.
Метод arrayOutOfBoundsException - Ошибка, связанная с выходом за пределы массива
Метод divisionByZero - Деление на 0
Метод numberFormatException - Ошибка преобразования строки в число
Важно: они не должны принимать никаких аргументов
*/

public class Task1 {
    static class Answer {
        public static void arrayOutOfBoundsException() {
            // Напишите свое решение ниже
            int [] intArray = new int[10];
            intArray[11] = 20;
        }

        public static void divisionByZero() {
            // Напишите свое решение ниже
            int a = 10;
            int b = 0;

            int c = a/b;
        }

        public static void numberFormatException() {
            // Напишите свое решение ниже
            String str = "123b";
            int a  = Integer.parseInt(str);
        }
    }

    public static void main(String[] args) {

        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array error");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Zero");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("parse int");
        }
    }
}


