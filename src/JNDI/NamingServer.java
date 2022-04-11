package JNDI;

import JNDI.HelloImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class NamingServer {

    public static void main(String[] args) {
        try {
            HelloImpl hello = new HelloImpl();
            //注册RMI端口
            LocateRegistry.createRegistry(10999);
            //绑定对象
            Naming.bind("rmi://localhost:10999/hello",hello);
            System.out.println("启动RMI服务成功！");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}