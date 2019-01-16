/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_login;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;

/**
 *
 * @author radhial22
 */
public interface inface_ceklog extends Remote{
    public String loginLevel(Connection cenn, entitas_login ent)throws RemoteException;
    public String logIn(entitas_login ent)throws RemoteException;
    
    entitas_login gett(String id, String pass)throws RemoteException;
            }
