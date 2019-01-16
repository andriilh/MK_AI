/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import entity.entitas_login;
import implement.ceklog;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author radhial22
 */
public class conn {
  private static Connection cekkoneksi;
  private static ceklog loginlevel;
  
  public static Connection getcekkoneksi(){
      Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("Server.properties"));
        } catch (IOException ex) {
            Logger.getLogger(conn.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        String ip = prop.getProperty("ip");
        String nmdb = prop.getProperty("namadb");
        String user = prop.getProperty("user");
        String pass = prop.getProperty("pass");
        
      if(cekkoneksi==null){
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                cekkoneksi = DriverManager.getConnection("jdbc:mysql://"+ip+":3306/"+nmdb+"", ""+user+"", ""+pass+"");
            } catch (SQLException ex) {
                
                Logger.getLogger(conn.class.getName()).log(Level.SEVERE, null, ex);
            }
      }return cekkoneksi;
  }
  }

