package Lesson_03;

/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные
пробелом:
Фамилия Имя Отчество датарождения номертелефона пол

Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки,
 обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных
не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать
свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны
записаться полученные данные, вида

<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен
увидеть стектрейс ошибки.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InputException extends Exception {
    public InputException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) throws InputException, IOException {

    }

    public static int inputData(){ //throws InputException, IOException {
//        int result = 0;
//        String dataInput = null;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         try {
             String dataInput = in.readLine();
             if (dataInput == null){
                 return -1;
             }else{
                 if(dataInput.length() == 0){
                     return -2;
                 }
                 String[] parts = dataInput.split(" ");
                 if(parts.length < 6){
                    return -3;
                 }

                 for (String part : parts) {
                     System.out.println(part);
                 }
             }
         }catch (IOException e) {
             System.out.println("Ошибка ввода данных: " + e.getMessage());
         }

        return 0;
    }

    static void RunApp() throws InputException{
        System.out.print("Введите данные: ");
        int inputResult = inputData();
        if (inputResult != 0) {

        }
    }

}
