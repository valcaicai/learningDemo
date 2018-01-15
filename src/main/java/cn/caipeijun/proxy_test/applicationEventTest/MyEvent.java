package cn.caipeijun.proxy_test.applicationEventTest;

import org.springframework.context.ApplicationEvent;

/**
 * <p/>
 * 自定义事件接口，暴露dell方法，处理事件
 * @author <a href="pigeon@kingyon.com">Pigeon</a>
 * caipeijun
 * 2018/1/12
 * @since 0.1.0
 */
public abstract class MyEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvent(Object source) {
        super(source);
    }

    public abstract void dell();

}
