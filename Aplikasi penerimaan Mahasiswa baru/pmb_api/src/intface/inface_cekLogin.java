/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_login;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author radhial22
 */
public interface inface_cekLogin extends Remote {
    entitas_login login(String id, String pass)throws RemoteException;
}
