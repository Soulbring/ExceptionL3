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
                    userData[3] = scanner.nextLine();
                } else {
                    System.out.println("Неправильный ввод. Пожалуйста, введите 'y' или 'n'.");
                }
            }
        }

        while (true) {
            date = userData[4];

            if (isValidNumber(date)) {
                break;
            } else {
                System.out.println("Номер введен не корректно: " + date);
                System.out.println("Хотите ввести номер заново? (y/n)");
                String response = scanner.nextLine();

                if (response.equalsIgnoreCase("n")) {
                    System.out.println("Завершение программы");
                    System.exit(0);
                } else if (response.equalsIgnoreCase("y")) {
                    System.out.println("Введите номер. Он должен быть в формате long  не отрицательным");
                    userData[4] = scanner.nextLine();
                } else {
                    System.out.println("Неправильный ввод. Пожалуйста, введите 'y' или 'n'.");
                }
            }
        }

        while (true) {
            date = userData[5];

            if (isValidGender(date)) {
                break;
            } else {
                System.out.println("Пол введен неверно: " + date);
                System.out.println("Хотите ввести пол заново? (y/n)");
                String response = scanner.nextLine();

                if (response.equalsIgnoreCase("n")) {
                    System.out.println("Завершение программы");
                    System.exit(0);
                } else if (response.equalsIgnoreCase("y")) {
                    System.out.println("Для выбора мужского пола введите m, для женского f");
                    userData[5] = scanner.nextLine();
                } else {
                    System.out.println("Неправильный ввод. Пожалуйста, введите 'y' или 'n'.");
                }
            }
        }

        System.out.println("Фамилия: " + userData[0]);
        System.out.println("Имя: " + userData[1]);
        System.out.println("Отчество: " + userData[2]);
        System.out.println("Дата рождения: " + userData[3]);
        System.out.println("Номер телефона: " + userData[4]);
        System.out.println("Пол: " + userData[5]);

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


    public static boolean isValidNumber(String telNum) {
        String input = telNum;
        try {
            long result = Long.parseLong(input);
            if (result > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }


    public static boolean isValidGender(String gender) {
        String input = gender;
        try {
            if (input.length() != 1) {
                throw new Exception("Ввод должен состоять из одного символа.");
            }

            char letter = input.charAt(0);
            if (letter == 'f' || letter == 'm') {
                return true;
            } else {
                throw new Exception("Введена неверная буква. Пожалуйста, введите 'f' или 'm'.");
            }
        } catch (Exception e) {
            return false;
        }
    }
}


