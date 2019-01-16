/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import com.mysql.jdbc.PreparedStatement;
import entity.entitas_tes;
import intface.inface_tes;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.conn;

/**
 *
 * @author radhial22
 */
public class imple_test extends UnicastRemoteObject implements inface_tes{
    
    public imple_test()throws RemoteException{
        
    }

    @Override
    public entitas_tes coun() throws RemoteException {
        try {
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select count(*) as no from tb_tes order by no asc");
            entitas_tes ent = new entitas_tes();
            while(rs.next()){
                ent.setCount(rs.getInt("no")+1);
            }
            return ent;
        } catch (SQLException ex) {
            Logger.getLogger(imple_test.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
