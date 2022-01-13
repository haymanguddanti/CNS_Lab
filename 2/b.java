import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class b {
    public static void main(String[] args) throws Exception {

        KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");

        SecretKey secretkey = keygenerator.generateKey();

        Cipher cipher = Cipher.getInstance("Blowfish");

        cipher.init(Cipher.ENCRYPT_MODE, secretkey);

        String inputText = "meh";

        byte[] encrypted = cipher.doFinal(inputText.getBytes());

        cipher.init(Cipher.DECRYPT_MODE, secretkey);

        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println("Encrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);

        System.exit(0);
    }
}
