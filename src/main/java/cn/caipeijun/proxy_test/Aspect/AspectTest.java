package cn.caipeijun.proxy_test.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p/>
 *
 * @author <a href="pigeon@kingyon.com">Pigeon</a>
 * caipeijun
 * 2018/1/12
 * @since 0.1.0
 */
@Aspect
@Component
//@EnableAspectJAutoProxy //这个注解会自动代理aspect注解的类，有了这个注解 @component注解可以不用写
public class AspectTest {


    @Pointcut("execution(* cn.caipeijun.proxy_test.Aspect.CommonClass.testWithAspect*(..) )")
    public void test(){
    }

    @Around("test()")
    public void aroundTest(ProceedingJoinPoint point) throws Throwable {

        System.out.println("before doing something");
        point.proceed();
        System.out.println("after doing something ");

    }


}
