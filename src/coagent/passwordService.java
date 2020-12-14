/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coagent;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lenovo
 */
public class passwordService {
    
    public static void savePassword(String password, String user) throws Exception {
        
        MessageDigest md;
        try {
            System.out.println("before prepared statmen");
            md = MessageDigest.getInstance("SHA-256");
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            
            md.update(salt);
            
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            
            StringBuilder stringBuilder = new StringBuilder();
            
            for(byte b : hashedPassword)
                stringBuilder.append(String.format("%02x", b));
            
            Connection con = Coagent.getConnection();
            System.out.println("before prepared statmen");
            PreparedStatement postUser = con.prepareStatement("INSERT INTO agents(Agent_Username, Agent_Hash_Password) VALUES('" + user + "', '" + String.valueOf(stringBuilder) + "')", Statement.RETURN_GENERATED_KEYS);
            System.out.println("before post");
            postUser.executeUpdate();
            System.out.println("after post");
            ResultSet result = postUser.getGeneratedKeys();
            int generatedKey = 0;
            if(result.next()) {
                generatedKey = result.getInt(1);
                System.out.println(generatedKey);
            }
            PreparedStatement postSalt = con.prepareStatement("INSERT INTO passwordSalt(Agent_Agent_Id, Salt) VALUES('" + generatedKey + "', '" + String.valueOf(salt) + "')");
            postSalt.executeUpdate();
            
            //output to db
            System.out.println(stringBuilder);
            System.out.println(salt);
            //comparePassword(password, stringBuilder, salt);
            
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }
    
    public static void comparePassword(String User, String inputPassword, StringBuilder hash, byte[] salt) throws Exception {
        Connection con = Coagent.getConnection();
        PreparedStatement query = con.prepareStatement("SELECT agents.Agent_Hash_Password, passwordSalt.Salt FROM agents JOIN passwordSalt WHERE agents.Agent_Id = passwordSalt.Agent_Agent_");
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
