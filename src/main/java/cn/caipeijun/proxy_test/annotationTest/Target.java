package cn.caipeijun.proxy_test.annotationTest;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class Target implements Hello {

    @MyLog(name = "蔡沛君",target = "所有人")
    public void sayHello(){
        System.out.println("sayHello");
    }

    public void sayHello2(){
        System.out.println("我不好");
    }


    public static void main(String[] args) {
        //cglib实现
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "cglib");
        //假定一个对象工厂，所有支持这个注解的对象都需要通过这个工厂来实例化

        CglibAop cglibAop = new CglibAop();//拦截器实现逻辑
        Enhancer enhancer =  new Enhancer();
        enhancer.setSuperclass(Target.class);//设置代理的类
        enhancer.setCallback(cglibAop);//设置方法拦截
        Target target = (Target) enhancer.create();//创建代理类
        target.sayHello();
        target.sayHello2();

        //jdkProxy实现
        JDKProxy jdkProxy = new JDKProxy();
        jdkProxy.setTarget(new Target());
        Target target1 = new Target();

        Hello hello = (Hello) Proxy.newProxyInstance(target1.getClass().getClassLoader(),Target.class.getInterfaces(),jdkProxy);
        hello.sayHello();
        hello.sayHello2();
    }

}
