package cn.caipeijun.proxy_test.applicationEventTest;

import org.springframework.context.ApplicationListener;
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
public class MyEventListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        event.dell();
    }
}
