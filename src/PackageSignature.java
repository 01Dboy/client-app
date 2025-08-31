import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PackageSignature {

    private static Set<String> usedSignatures = Collections.synchronizedSet(new HashSet<>());
    private static final String CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
    private static final Random random = new Random();

    private PackageSignature() {

    }

    private static String generateSignature(){

        StringBuffer signature = new StringBuffer(8);

        for (int i = 0; i < 8; i++) {
            signature.append(CHAR.charAt(random.nextInt(CHAR.length())));
        }

        return signature.toString();

    }

    public static String getSignature() {

        String signature;

        do {
            signature = generateSignature();
        } while (!usedSignatures.add(signature));


        return signature;

    }

}
