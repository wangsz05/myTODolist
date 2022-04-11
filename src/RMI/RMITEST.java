package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class RMITEST {
    public static void main(String[] args) throws RemoteException {

        //// 将RMI服务注册到1099端口:
        Registry registry = LocateRegistry.createRegistry(1098);
        //实例化对象
        RemoteHello h = new RemoteHelloImpl();
        //用于导出远程对象，将此服务转换为远程服务接口
            RemoteHello skeleton = (RemoteHello) UnicastRemoteObject.exportObject(h, 0);

        // 注册此服务，服务名为"Hello":
        //Naming.rebind("rmi://127.0.0.1:1099/Hello", h);
        registry.rebind("Hello", h);


    }
}