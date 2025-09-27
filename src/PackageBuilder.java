import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;



public class PackageBuilder {

    private PackageBuilder(){}

    public static byte[] buildPackage(UserData userData) {

        try {
            String dataType = getDataType(userData.getChoice());
            byte[] dataTypeBytes = dataType.getBytes(StandardCharsets.UTF_8);
            byte[] dataBytes = userData.getData().getBytes(StandardCharsets.UTF_8);
            int dataLength = dataBytes.length;

            ByteArrayOutputStream oStream = new ByteArrayOutputStream();
            DataOutputStream odStream = new DataOutputStream(oStream);

            odStream.write(ClientConfig.SIGNATURE_BYTES);
            odStream.write(dataTypeBytes);
            odStream.writeInt(dataLength);
            odStream.write(dataBytes);

            CRC32 crc32 = new CRC32();
            crc32.update(oStream.toByteArray());
            long crc = crc32.getValue();
            odStream.writeInt((int) crc);

            return oStream.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Возникла ошибка формирования пакета ", e);
        }

    }

    private static String getDataType(int number) {

        switch (number) {
            case 1:
                return "CONSOLE";
            case 2:
                return "PLAIN  ";
            case 3:
                return "JSON   ";
            default:
                throw new IllegalStateException("Ошибка значения getDataType: " + number);
        }

    }

}


