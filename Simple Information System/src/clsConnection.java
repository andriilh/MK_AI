
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class clsConnection
{
     public static Connection conn;
    String url = "jdbc:mysql://localhost/studentregistration";
    String driver = "com.mysql.jdbc.Driver";
    
    Connection con;
    Statement stm;
    
//    public void config(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con=DriverManager.getConnection("jdbc:mysql://localhost/studentregistration", "root", "");
//            stm = con.createStatement();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
//        }
//    }
    
    public clsConnection(){
        try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url);
        }catch (Exception e) {
        }

//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Berhasil Koneksi");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Gagal Koneksi "+ex);
//        }
//        String url = "jdbc:mysql://localhost/studentregistration";
//        try {
//            conn = DriverManager.getConnection(url, "root", "");
//            System.out.println("Berhasil Koneksi Database");
//        } catch (SQLException ex) {
//            System.out.println("Gagal Koneksi Database "+ex);
//        }
//        return conn;
    }
}
