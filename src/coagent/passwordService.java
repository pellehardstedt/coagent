/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coagent;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lenovo
 */
public class passwordService {
    
    public static void savePassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            
            md.update(salt);
            
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            
            StringBuilder stringBuilder = new StringBuilder();
            
            for(byte b : hashedPassword)
                stringBuilder.append(String.format("%02x", b));
            
            //output to db
            System.out.println(stringBuilder);
            System.out.println(salt);
            comparePassword(password, stringBuilder, salt);
            
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }
    
    public static void comparePassword(String inputPassword, StringBuilder hash, byte[] salt) {
        MessageDigest md;
        try {
            
            md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedInputPassword = md.digest(inputPassword.getBytes(StandardCharsets.UTF_8));
            StringBuilder hashedInputPasswordBuilt = new StringBuilder();
            for(byte b : hashedInputPassword)
                hashedInputPasswordBuilt.append(String.format("%02x", b));
            
            if( String.valueOf(hashedInputPasswordBuilt).equals(String.valueOf(hash))){
                System.out.println(hashedInputPasswordBuilt);
                System.out.println(hash);
                System.out.println("yes");
            }
            
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }
    
}
