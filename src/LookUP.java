
import JNDI.Hello;

import java.rmi.RemoteException;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class LookUP {

    public static void main(String[] args) throws NamingException, RemoteException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
//com.sun.jndi.rmi.registry.RegistryContextFactory 是RMI Registry Service Provider对应的Factory
        env.put(Context.PROVIDER_URL, "rmi://localhost:10999");
        Context ctx = new InitialContext(env);
//        Object object =  ctx.lookup("rmi://localhost:10999/hello");
        //jndi方式获取远程对象
        Hello rHello = (Hello)ctx.lookup("rmi://localhost:10999/hello");
        System.out.printf(rHello.welcome("tridentj"));

    }
}
