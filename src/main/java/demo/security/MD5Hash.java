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
        String hashString = hash.calculate("koira");
    }

    public String calculate(String s){
        String hashString = null;

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            hashString = sb.toString();

            System.out.println("original:" + s);
            System.out.println("digested(hex):" + sb.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return  hashString;
    }
}
