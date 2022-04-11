package JNDI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello{

    public HelloImpl() throws RemoteException {

    }

    @Override
    public String welcome(String name) throws RemoteException {
        return "JNDI.Hello, " + name;
    }
}