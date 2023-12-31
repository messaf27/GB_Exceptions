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

public class Main {
    static void RunApp() throws InputException {
        DataParser dataParser = new DataParser();
        int inputResult = dataParser.inputData("Введите данные: ");

        switch (inputResult) {
            case 0 -> dataParser.saveToFile();
            case -1 -> throw new InputException("Размер введеных данных не корректен" + ", код ошибки " + inputResult);
            case -2 -> throw new InputException("Количество указанных параметров не совпадает с форматом" +
                    ", код ошибки " + inputResult);
            case -3 -> throw new InputException("Параметр ФИО введён не корректрно!" + ", код ошибки " + inputResult);
            case -4 -> throw new InputException("Параметр Дата введён не корректрно!" + ", код ошибки " + inputResult);
            case -5 -> throw new InputException("Параметр Номер телефона введён не корректрно!" + ", код ошибки " +
                    inputResult);
            case -6 -> throw new InputException("Параметр Пол введён не корректрно!" + ", код ошибки " + inputResult);
            default -> throw new InputException("Для кода данной ошибки пока нет описания" + ", код ошибки " +
                    inputResult);
        }
    }
    public static void main(String[] args) {

        boolean endApp = false;
        int errorCounter = 0, maxErrors = 3;

        while (errorCounter < maxErrors && !endApp){
            try{
                RunApp();
                endApp = true;
            }catch (InputException ex){
                errorCounter ++;
                System.out.println(ex.getMessage());
            }
            finally {
                if(!endApp){
                    if(maxErrors - errorCounter == 0){
                        System.out.println("Вы исчерпали все попытки, приложение закрывается.");
                    }else {
                        System.out.printf("Ошибка ввода, осталось %d попыток \n", maxErrors - errorCounter);
                    }
                }else{
                    System.out.println("Программа завершилась без ошибок.");
                }
            }
        }
    }
}
