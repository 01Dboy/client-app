import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class PackageSender {

    public boolean send(byte[] packet) {
        try (Socket socket = new Socket(ClientConfig.HOST, ClientConfig.PORT);
             OutputStream output = socket.getOutputStream()) {

            output.write(packet);
            output.flush();

            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
