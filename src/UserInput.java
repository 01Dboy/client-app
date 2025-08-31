import java.util.Scanner;
import java.util.concurrent.Callable;

public class UserInput implements Callable<Integer> {

    @Override
    public Integer call() {

        Scanner scanner = new Scanner(System.in);
        return dataFormat(scanner);

    }

    private int dataFormat(Scanner scanner) {

        UserInterface.helloInstructionMessage();

        int choiceNumber = intInputData(scanner);

        while ((choiceNumber <1)||(choiceNumber >3)) {
            System.out.println("Цифра должна быть от 1 до 3х включительно! Повторите ввод.");
            choiceNumber = intInputData(scanner);
        }

        return choiceNumber;

    }

    private int intInputData(Scanner scanner) {

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

}
