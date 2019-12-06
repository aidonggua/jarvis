package jarvis;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestCGLib {

    static {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/yehao/log");
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestCGLib.class);
        enhancer.setCallback(new TestMethodInterceptor());
        TestCGLib testCGLib = (TestCGLib) enhancer.create();
        testCGLib.hello();
    }

    public void hello() {
        System.out.println("beautiful");
    }
}

class TestMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("hello");
        methodProxy.invokeSuper(o, objects);
        System.out.println("world");
        return o;
    }
}