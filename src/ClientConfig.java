import java.nio.charset.StandardCharsets;

public class ClientConfig {

    private ClientConfig() {}

    public static final String PACKAGE_SIGNATURE = "SIGNAT99";
    public static final byte[] SIGNATURE_BYTES = PACKAGE_SIGNATURE.getBytes(StandardCharsets.UTF_8);

    public static final String HOST = "localhost";
    public static final int PORT = 8080;

    public static final String PURPLE = "\u001B[35m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";


}
