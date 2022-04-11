package JNDI;

import java.rmi.Naming;

public class NamingClient {

    public static void main(String[] args){
        try {
            Hello hello = (Hello) Naming.lookup("rmi://localhost:10999/hello");
            System.out.println(hello.welcome("tridentj"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}