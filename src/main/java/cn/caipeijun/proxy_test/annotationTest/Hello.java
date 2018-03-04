package cn.caipeijun.proxy_test.annotationTest;

/**
 * <p/>
 *
 * @author <a href="pigeon@kingyon.com">Pigeon</a>
 * caipeijun
 * 2018/1/17
 * @since 0.1.0
 */
public interface Hello  {

    @MyLog(name = "caipeijun",target = "dashabi")
    void sayHello();

    @MyLog(name = "dashabi",target = "caipeijun")
    void sayHello2();

}
