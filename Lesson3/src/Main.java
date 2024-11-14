import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате : Фамилия Имя Отчество Дата_рождения Номер_телефона Пол");
        String[] userData = getUserData(scanner);
        String date;

        while (true) {
            date = userData[3];

            if (isValidDate(date)) {
                break;
            } else {
                System.out.println("Дата рождения некорректна: " + date);
                System.out.println("Хотите ввести дату заново? (y/n)");
                String response = scanner.nextLine();

                if (response.equalsIgnoreCase("n")) {
                    System.out.println("Завершение программы");
                    System.exit(0);
                } else if (response.equalsIgnoreCase("y")) {
                    System.out.println("Введите данные в формате : dd.MM.yyyy");
                    userData [3] = scanner.nextLine();
                } else {
                    System.out.println("Неправильный ввод. Пожалуйста, введите 'y' или 'n'.");
                }1
            }
        }

        String lastName = userData[0];
        String firstName = userData[1];
        String middleName = userData[2];
        String birthDate = userData[3];
        String phoneNumber = userData[4];
        String gender = userData[5];

        System.out.println("Фамилия: " + lastName);
        System.out.println("Имя: " + firstName);
        System.out.println("Отчество: " + middleName);
        System.out.println("Дата рождения: " + birthDate);
        System.out.println("Номер телефона: " + phoneNumber);
        System.out.println("Пол: " + gender);

        scanner.close();
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
                } else {
                    System.out.println("Неправильный ввод. Пожалуйста, введите 'y' или 'n'.");
                }
            }
        }

        return data;
    }

    public static boolean isValidDate(String dateStr) {
        final String DATE_FORMAT = "dd.MM.yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
