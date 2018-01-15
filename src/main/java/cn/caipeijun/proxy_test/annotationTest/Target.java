package cn.caipeijun.proxy_test.annotationTest;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class Target {

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
        CglibAop cglibAop = new CglibAop();
        Enhancer enhancer =  new Enhancer();
        enhancer.setSuperclass(Target.class);
        enhancer.setCallback(cglibAop);
        Target target = (Target) enhancer.create();
        target.sayHello();
        target.sayHello2();

        //jdkProxy实现
        JDKProxy jdkProxy = new JDKProxy();
        jdkProxy.setTarget(new Target());
        Target target1 = new Target();

        Target target2 = (Target) Proxy.newProxyInstance(target1.getClass().getClassLoader(),Target.class.getInterfaces(),jdkProxy);
        target2.sayHello();
        target2.sayHello2();
    }

}
