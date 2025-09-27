public class UserInterface {

    private UserInterface() {

    }

    public static void helloInstructionMessage() {

        System.out.println();
        System.out.println("_____________");
        System.out.println("Добрый день!");
        System.out.println();
        System.out.println("Для отправки данных (не более 200 символов) на сервер, сначала надо выбрать действия сервера по отношению к этим данным.");
        System.out.println("Для выбора формата действия вам надо ввести цифру от 1 до 3:");
        System.out.println();
        System.out.println("1 - Сервер выведет отправленные данные в консоль");
        System.out.println("2 - Сервер сохранит данные в файл");
        System.out.println("3 - Сервер сохранит данные в файл с типом JSON и JSON-форматированием");
        System.out.println();
        System.out.println("--Что из этого необходимо сделать?");

    }

    public static void dataInstructionMessage() {

        System.out.println("--Ваш выбор принят, теперь введите данные (не более 200 символов):");
        System.out.println();

    }

}
