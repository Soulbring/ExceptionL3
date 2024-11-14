//region Задание
//          Проверка корректности даты
//      Напишите приложение, которое будет запрашивать у пользователя следующие
//данные впроизвольном порядке, разделенные пробелом:
//Фамилия ИмяОтчестводатарождения номертелефона пол
//Форматыданных:
//фамилия, имя, отчество- строки
//дата_рождения- строка формата dd.mm.yyyy
//номер_телефона- целое беззнаковое число без форматирования
//пол- символ латиницей f или m.
//Приложение должно проверить введенные данные по количеству. Если
//количество не совпадает с требуемым, вернуть код ошибки, обработать его и
//показать пользователю сообщение, что он ввел меньше и больше данных, чем
//требуется.
//Приложение должно попытаться распарсить полученные значения и выделить из
//них требуемые параметры. Если форматы данных не совпадают, нужно бросить
//исключение, соответствующее типу проблемы. Можно использовать встроенные
//типы java и создать свои. Исключение должно быть корректно обработано,
//пользователю выведено сообщение с информацией, что именно неверно.
//Если всё введено и обработано верно, должен создаться файл с названием,
//равным фамилии, в него в однустроку должны записаться полученные данные,
//вида
//        <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
//        Однофамильцы должны записаться в один и тот же файл,в отдельные строки.
//Не забудьте закрыть соединение с файлом.
//При возникновении проблемы с чтением-записью в файл, исключение должно
//быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
//endregion

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате : Фамилия Имя Отчество Дата_рождения Номер_телефона Пол");
        String[] userData = getUserData(scanner);


        String firstName = userData[0];
        String lastName = userData[1];
        String middleName = userData[2];
        String birthDate = userData[3];
        String phoneNumber = userData[4];
        String gender = userData[5];

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(middleName);
        System.out.println(birthDate);
        System.out.println(phoneNumber);
        System.out.println(gender);
    }

    public static String[] getUserData(Scanner scanner) {

        String[] data = null;
        boolean validInput = false;
        while (!validInput) {
            String input = scanner.nextLine();
            data = input.split(" ");

            if (data.length == 6) {
                validInput = true;
            } else {

                System.out.println("Ошибка: Введено должно быть 6 значений");
                System.out.println("Хотите попробовать снова? (y/n)");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("y")) {
                    continue;
                } else if (response.equalsIgnoreCase("n")) {
                    System.out.println("Завершение программы");
                    System.exit(0);
                }

            }
        }

        return data;
    }
}

