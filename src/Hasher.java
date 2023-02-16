import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class Hasher {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter message: ");
        String input = in.nextLine();
        CharSequence originalString = "null";
        HashFunction hf = Hashing.sha256();
        HashCode hc = hf.newHasher()
                .putString(input, Charset.defaultCharset()).hash();
        System.out.println(hc);
    }
}