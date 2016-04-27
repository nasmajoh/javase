package demo.security;

import java.io.UnsupportedEncodingException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by nasmajoh on 25.4.2016.
 */
public class MD5Hash {

    public static void main(String[] args) {
        MD5Hash hash = new MD5Hash();
        hash.calculate("koira");
    }

    public void calculate(String s){

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            String test = new String(digest, "UTF-8");

            System.out.println("original:" + s);
            System.out.println("digested(hex):" + sb.toString());
            System.out.println("digested(utf):" + test);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
