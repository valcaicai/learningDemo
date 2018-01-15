package cn.caipeijun.proxy_test;

import cn.caipeijun.proxy_test.Aspect.CommonClass;
import cn.caipeijun.proxy_test.applicationEventTest.MyEventImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxyTestApplicationTests {

	@Autowired
	CommonClass commonClass;

	@Autowired
	ApplicationContext context;

	/**
	 * 测试spring 事件发布捕获功能
	 * @throws InterruptedException
	 */
	@Test
	public void testEvent() throws InterruptedException {

		context.publishEvent(new MyEventImpl("","caipeijun","hello"));

		Thread.sleep(1000);

	}

	/**
	 * 测试aop性能
	 */
	@Test
	public void testAopPerformance() {

		LocalDateTime start1 =  LocalDateTime.now();

		int times = 1;

		for(int i=0;i<times;i++){
			commonClass.testWithOutAspect();
		}

		long l = Duration.between(start1, LocalDateTime.now()).toNanos();

		LocalDateTime start2 = LocalDateTime.now();

		for(int i=0;i<times;i++){
			commonClass.testWithAspect();
		}

		long l1 = Duration.between(start2, LocalDateTime.now()).toNanos();

		System.out.println("没有切面用时"+l);

		System.out.println("使用切面用时"+l1);

		System.out.println("不使用切面比使用快"+(l1-l)/(1000.0*1000.0*1000.0)+"秒");

	}

}
