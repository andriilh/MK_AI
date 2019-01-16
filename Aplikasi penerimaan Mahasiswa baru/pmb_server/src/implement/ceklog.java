/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.entitas_login;
import intface.inface_ceklog;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.conn;

/**
 *
 * @author radhial22
 */
public class ceklog extends UnicastRemoteObject implements inface_ceklog{
    
    public ceklog()throws RemoteException{
        
    }

    @Override
    public String loginLevel(Connection cenn, entitas_login ent) throws RemoteException {
        String level = "";
       
        try {
            String query ="select * from tb_login where id_user='"+ent.getId()+"'and pass = '"+ent.getPass()+"'";
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery(query);
            String id_user ="",pass="",status="";
            while(rs.next()){
                id_user = rs.getString("id_user");
                pass= rs.getString("pass");
                status = rs.getString("status");
            }
            if(id_user.equals(ent.getId())&&pass.equals(ent.getPass())){
                if(status.equals("Admin")){
                    level = "Admin";
                }else if(status.equals("User Cs")){
                    level = "User Cs";
                }else if (status.equals("User Asisten")){
                    level = "User Asisten";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ceklog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return level;
    }

    @Override
    public String logIn(entitas_login ent) throws RemoteException {
        String level = "";
       
        try {
            String query ="select * from tb_login where id_user='"+ent.getId()+"'and pass = '"+ent.getPass()+"'";
            Statement st = conn.getcekkoneksi().createStatement();
            ResultSet rs = st.executeQuery(query);
            String id_user ="",pass="",status="";
            while(rs.next()){
                id_user = rs.getString("id_user");
                pass= rs.getString("pass");
                status = rs.getString("status");
            }
            if(id_user.equals(ent.getId())&&pass.equals(ent.getPass())){
                if(status.equals("Admin")){
                    level = "Admin";
                }else if(status.equals("User Cs")){
                    level = "User Cs";
                }else if (status.equals("User Asisten")){
                    level = "User Asisten";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ceklog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return level;
    }

    
    public entitas_login gett() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public entitas_login gett(String id, String pass) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    }
