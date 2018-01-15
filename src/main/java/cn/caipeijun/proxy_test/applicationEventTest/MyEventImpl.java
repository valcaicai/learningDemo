package cn.caipeijun.proxy_test.applicationEventTest;

/**
 * <p/>
 *
 * @author <a href="pigeon@kingyon.com">Pigeon</a>
 * caipeijun
 * 2018/1/12
 * @since 0.1.0
 */
public class MyEventImpl extends  MyEvent{

    private String name;

    private String hello;

    public MyEventImpl(Object source) {
        super(source);
    }

    public MyEventImpl(Object source, String name, String hello) {
        super(source);
        setName(name);
        setHello(hello);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    @Override
    public void dell() {
        System.out.println("处理自定义事件中");
        System.out.println(this.hello+","+this.name);
    }
}
