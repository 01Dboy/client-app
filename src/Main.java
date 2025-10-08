import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {

        BlockingQueue<UserData> queueInputToPacking = new LinkedBlockingQueue<>();
        BlockingQueue<byte[]> queuePackingToSend = new LinkedBlockingQueue<>();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new DataInputThread(queueInputToPacking));
        executorService.execute(new DataPackingThread(queueInputToPacking, queuePackingToSend));
        executorService.execute(new DataSendThread(queuePackingToSend));


        System.out.println(ClientConfig.PURPLE + "Все потоки запущены в пуле потоков." + ClientConfig.RESET);

    }

}