/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intface;

import entity.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author radhial22
 */
public interface intface_presenter extends Remote{
    entitas_presenter insert(entitas_presenter r)throws RemoteException;
    void update (entitas_presenter r)throws RemoteException;
    void delete (String id)throws RemoteException;
    List<entitas_presenter>getall()throws RemoteException;
}
