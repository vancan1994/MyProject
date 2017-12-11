package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class PasswordUtil {
    public static String getSalt(){
        Random r = new SecureRandom();
        byte[] saltByte= new byte[32];
        r.nextBytes(saltByte);
        return Base64.getEncoder().encodeToString(saltByte);
    }
    public static String hashPassword(String password) throws NoSuchAlgorithmException{
        StringBuilder sb;
        MessageDigest md= MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] mdArray=md.digest();
        sb= new  StringBuilder(mdArray.length*2);
        for(byte b:mdArray){
            int v=b&0xff;
            if(v<16){
                sb.append("0");
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();
    }
    
}
