import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class DataSendThread extends Thread {
    private final BlockingQueue<byte[]> inputQueue;

    public DataSendThread(BlockingQueue<byte[]> inputQueue) {
        this.inputQueue = inputQueue;
    }

    @Override
    public void run() {
        System.out.println(ClientConfig.PURPLE + "Поток отправки запущен." + ClientConfig.RESET);

        try {
            PackageSender sender = new PackageSender();

            while (!isInterrupted()) {
                byte[] packet = inputQueue.take();
                System.out.println(ClientConfig.PURPLE + "Получен пакет для отправки." + ClientConfig.RESET);

                if (sender.send(packet)) {
                    System.out.println(ClientConfig.GREEN + "Пакет успешно отправлен." + ClientConfig.RESET);
                } else {
                    System.out.println(ClientConfig.RED + "Ошибка отправки пакета." + ClientConfig.RESET);
                }

                Thread.sleep(500);

            }
        } catch (InterruptedException e) {
            System.out.println(ClientConfig.RED + "Поток отправки прерван." + ClientConfig.RESET);
        } finally {
            System.out.println(ClientConfig.PURPLE + "Поток отправки завершил работу." + ClientConfig.RESET);
        }
    }
}
