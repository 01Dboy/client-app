import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Package implements Runnable {

    private static Set<String> usedSignatures = Collections.synchronizedSet(new HashSet<>());
    private static final String CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
    private final Random random = new Random();

    @Override
    public void run() {

        String signature = getSignature();
        UserInput userInput = new UserInput();
        String dataType = dataType(userInput.call());

    }

    private String generateSignature(){

        StringBuffer signature = new StringBuffer(8);

        for (int i = 0; i < 8; i++) {
            signature.append(CHAR.charAt(random.nextInt(CHAR.length())));
        }

        return signature.toString();

    }

    private String getSignature() {

        String signature;

        do {
            signature = generateSignature();
        } while (!usedSignatures.add(signature));


        return signature;

    }

    private String dataType (int number) {

        switch (number) {
            case 1: return "CONSOLE";
            case 2: return "PLAIN  ";
            case 3: return "JSON   ";
            default: return "";
        }

    }

}
