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
import java.util.Arrays;
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
            PreparedStatement postUser = con.prepareStatement("INSERT INTO agents(Agent_Username, Agent_Hash_Password) VALUES('" + user + "', '" + stringBuilder + "')", Statement.RETURN_GENERATED_KEYS);
            postUser.executeUpdate();
            ResultSet result = postUser.getGeneratedKeys();
            int generatedKey = 0;
            if(result.next()) {
                generatedKey = result.getInt(1);
                System.out.println(generatedKey);
            }
            PreparedStatement postSalt = con.prepareStatement("INSERT INTO passwordSalt(Agent_Agent_Id, Salt) VALUES('" + generatedKey + "', '" + salt + "')");
            postSalt.executeUpdate();
                        
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }

    public static Boolean comparePassword(String username, String inputPassword) throws Exception {
        int id = getUserId(username);
        if(id == 0){
            return false;
        }
        Connection con = Coagent.getConnection();
        PreparedStatement query = con.prepareStatement("SELECT agents.Agent_Hash_Password, passwordSalt.Salt FROM agents JOIN passwordSalt ON agents.Agent_Id = passwordSalt.Agent_Agent_Id WHERE agents.Agent_Id = " + id + ";");
        ResultSet result = query.executeQuery();
        result.next();
;
        byte[] hash = result.getBytes("agents.Agent_Hash_Password");

        byte[] salt = result.getBytes("passwordSalt.Salt");

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedInputPassword = md.digest(inputPassword.getBytes(StandardCharsets.UTF_8));

            StringBuilder hashInputBuild = new StringBuilder();
            for(byte b : hashedInputPassword)
                hashInputBuild.append(String.format("%02x", b));
            
            StringBuilder hashDBbuild = new StringBuilder();
            for(byte b : hashedInputPassword)
                hashDBbuild.append(String.format("%02x", b));
          
            //not working properly
            if(hashInputBuild.equals(hashDBbuild)){
                System.out.println("Logged in");
                return true;
            } else {
                return true;
            }
            
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return false;
    }

    private static int getUserId(String user) {
        Connection con;
        int id = 0;
        try {
            con = Coagent.getConnection();
            PreparedStatement query = con.prepareStatement("SELECT Agent_ID FROM agents WHERE Agent_Username = '" + user + "';");
            ResultSet result = query.executeQuery();
            if(result.next()) {
                id = Integer.parseInt(result.getObject(1).toString());
            } else {
                id = 0;
            }
        } catch (Exception ex) {
            Logger.getLogger(passwordService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
}
