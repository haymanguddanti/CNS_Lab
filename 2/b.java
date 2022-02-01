import java.io.*;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

import java.security.*;

public class b {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("BlowFish");
        keyGenerator.init(128);
        Key secretKey = keyGenerator.generateKey();
        Cipher cipherOut = Cipher.getInstance("BlowFish/CFB/NoPadding");
        cipherOut.init(Cipher.ENCRYPT_MODE, secretKey);

        Base64.Encoder encoder = Base64.getEncoder();
        byte iv[] = cipherOut.getIV();
        if (iv != null)
            System.out.println(encoder.encodeToString(iv));
        FileInputStream fin = new FileInputStream("input.txt");
        FileOutputStream fout = new FileOutputStream("output.txt");
        CipherOutputStream cout = new CipherOutputStream(fout, cipherOut);
        int input;
        while ((input = fin.read()) != -1) {
            cout.write(input);
        }
        fin.close();
        cout.close();
    }
}
