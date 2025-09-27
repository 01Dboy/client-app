import java.util.concurrent.BlockingQueue;

public class DataInputThread extends Thread {
    private final BlockingQueue<UserData> outputQueue;
    private final UserInput userInput;

    public DataInputThread(BlockingQueue<UserData> outputQueue) {
        this.outputQueue = outputQueue;
        this.userInput = new UserInput();
        setName("DataInputThread");
    }

    @Override
    public void run() {
        System.out.println(ClientConfig.PURPLE + "Поток ввода данных запущен." + ClientConfig.RESET);

        try {

            boolean continueSending = true;
            int packageCount = 0;

            while (!isInterrupted()&&continueSending) {
                packageCount++;

                System.out.println(ClientConfig.PURPLE + "Отправка пакета №" + packageCount + ":" + ClientConfig.RESET);

                UserData userData = userInput.getUserData();

                if ("exit".equalsIgnoreCase(userData.getData())) {
                    System.out.println(ClientConfig.PURPLE + "Получена команда выхода." + ClientConfig.RESET);
                    break;
                }

                outputQueue.put(userData);

                System.out.println();
                System.out.println(ClientConfig.PURPLE + "Данные переданы на уровень упаковки." + ClientConfig.RESET);

                continueSending = userInput.askForContinue();

                Thread.sleep(1000);

            }

            System.out.println(ClientConfig.GREEN + "Отправлено пакетов: " + packageCount + ClientConfig.RESET);

        } catch (InterruptedException e) {
            System.out.println(ClientConfig.RED + "Поток ввода прерван." + ClientConfig.RESET);
        } finally {
            System.out.println(ClientConfig.PURPLE + "Поток ввода завершил работу." + ClientConfig.RESET);
        }
    }

}
