import java.util.Scanner;

public class UserInput {

    private static final Scanner scanner = new Scanner(System.in);

    public UserData getUserData() {

        int dataFormat = dataFormat();
        scanner.nextLine();
        String data = dataLimit();

        return new UserData(dataFormat, data);

    }

    private int dataFormat() {

        UserInterface.helloInstructionMessage();

        int choiceNumber = intInputData();

        while ((choiceNumber < 1) || (choiceNumber > 3)) {
            System.out.println("Цифра должна быть от 1 до 3х включительно! Повторите ввод.");
            choiceNumber = intInputData();
        }

        return choiceNumber;

    }

    private String dataLimit() {

        UserInterface.dataInstructionMessage();

        String data = stringInputData();

        while (data.length() > 200) {
            System.out.println("Символов должно быть не более 200! Повторите ввод.");
            data = stringInputData();
        }

        System.out.println();
        System.out.println("Принято.");
        return data;
    }

    private int intInputData() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка ввода!");
                System.out.println("Повторите ввод.");
                scanner.nextLine();
            }
        }
    }

    private String stringInputData() {
        while (true) {
            try {
                return scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Ошибка ввода!");
                System.out.println("Повторите ввод.");
                scanner.nextLine();
            }
        }
    }

    public boolean askForContinue() {

        System.out.println();
        System.out.println("--Хотите отправить еще один пакет? Введите Y если да и N, если нет:");

        while (true) {
            try {
                String answer = scanner.nextLine().trim().toLowerCase();

                if (answer.isEmpty()) {
                    System.out.println("Пожалуйста, введите Y или N");
                    continue;
                }

                if (answer.equals("y")) {
                    return true;
                } else if (answer.equals("n")) {
                    return false;
                } else {
                    System.out.println("Пожалуйста введите Y или N");
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода значения.");
            }
        }
    }

}
