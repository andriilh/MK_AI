/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.entitas_tes;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author radhial22
 */
public interface inface_tes extends Remote{
    entitas_tes coun()throws RemoteException;
}
