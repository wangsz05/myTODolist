package JNDI;

import RMI.RemoteHello;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws RemoteException {
        // 创建对象
        Hello hello = new HelloImpl();
        // 创建注册表
        Registry registry = LocateRegistry.createRegistry(20997);
        // 绑定对象到注册表，并给他取名为hello
        registry.rebind("hello",hello);
        System.out.println("创建服务端成功！");

    }
}