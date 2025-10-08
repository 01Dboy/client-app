import java.util.concurrent.BlockingQueue;

public class DataPackingThread extends Thread {
    private final BlockingQueue<UserData> inputQueue;
    private final BlockingQueue<byte[]> outputQueue;

    public DataPackingThread(BlockingQueue<UserData> inputQueue, BlockingQueue<byte[]> outputQueue) {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }

    @Override
    public void run() {
        System.out.println(ClientConfig.PURPLE + "Поток упаковки данных запущен." + ClientConfig.RESET);

        try {
            while (!isInterrupted()) {

                UserData userData = inputQueue.take();
                System.out.println(ClientConfig.PURPLE + "Получены данные для упаковки." + ClientConfig.RESET);

                byte[] packet = PackageBuilder.buildPackage(userData);
                System.out.println(ClientConfig.PURPLE + "Пакет собран." + ClientConfig.RESET);

                outputQueue.put(packet);
                System.out.println(ClientConfig.PURPLE + "Пакет передан на поток отправки." + ClientConfig.RESET);

            }
        } catch (InterruptedException e) {
            System.out.println(ClientConfig.PURPLE + "Поток упаковки прерван." + ClientConfig.RESET);
        } catch (Exception e) {
            System.out.println("Ошибка упаковки: " + e.getMessage());
        } finally {
            System.out.println(ClientConfig.PURPLE + "Поток упаковки завершил работу." + ClientConfig.RESET);
        }
    }

}
