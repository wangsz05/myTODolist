package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteHello extends Remote {
    String sayHello(String name) throws RemoteException;

    String exp1(Object work) throws RemoteException;

    Object exp2() throws Exception;
}