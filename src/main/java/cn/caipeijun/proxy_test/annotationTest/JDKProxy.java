package cn.caipeijun.proxy_test.annotationTest;

import java.lang.reflect.Executable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class JDKProxy implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        MyLog myLog = method.getDeclaredAnnotation(MyLog.class);

        if(myLog!=null){
            pre();
            System.out.println(myLog.name() + "向" + myLog.target());
            method.invoke(target,args);
            after();
        }
        return null;
    }

    public void setTarget(Object object){
        this.target = object;
    }
    private void after() {
        System.out.println("after say Hello");
    }


    private void pre() {
        System.out.println("before say Hello");
    }
}
