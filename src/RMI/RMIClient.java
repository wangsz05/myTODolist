package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) throws Exception {
        // 连接到服务器localhost，端口1099:
        Registry registry = LocateRegistry.getRegistry("localhost", 1098);
        // 查找名称为"Hello"的服务并强制转型为Hello接口:
        RemoteHello h = (RemoteHello) registry.lookup("Hello");
        // 正常调用接口方法:
        String rs = h.sayHello("rai4over");
        // 打印调用结果:
        System.out.println(rs);
    }
}