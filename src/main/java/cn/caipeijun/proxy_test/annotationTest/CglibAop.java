package cn.caipeijun.proxy_test.annotationTest;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class CglibAop implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("invoke...");
        MyLog myLog = method.getDeclaredAnnotation(MyLog.class);

        if (myLog != null) {
            pre();
            System.out.println(myLog.name() + "向" + myLog.target());
            methodProxy.invokeSuper(o, objects);
            after();
        }

        return null;
    }

    private void after() {
        System.out.println("after say Hello");
    }


    private void pre() {
        System.out.println("before say Hello");
    }

}
