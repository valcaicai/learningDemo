package cn.caipeijun.proxy_test.Aspect;

import org.springframework.stereotype.Component;

/**
 * <p/>
 *
 * @author <a href="pigeon@kingyon.com">Pigeon</a>
 * caipeijun
 * 2018/1/12
 * @since 0.1.0
 */
@Component
public class CommonClass {

    public void testWithAspect(){

        System.out.print("i am doing something whit pointCut around me");

    }

    public void testWithOutAspect(){

        System.out.print("before doing something");
        System.out.print("i am doing something myself");
        System.out.print("after doing something ");

    }

}
