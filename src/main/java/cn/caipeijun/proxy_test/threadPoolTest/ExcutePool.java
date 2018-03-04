package cn.caipeijun.proxy_test.threadPoolTest;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p/>
 *
 * @author <a href="pigeon@kingyon.com">Pigeon</a>
 * caipeijun
 * 2018/2/1
 * @since 0.1.0
 */
public class ExcutePool {

    public static volatile int count = 0;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i =0;i<2000;i++){
            executorService.execute(new MyThread());
        }

    }

    private static class MyThread implements Runnable{

        private LocalDateTime start = LocalDateTime.now();

        ExcutePool excutePool = new ExcutePool();

        @Override
        public void run() {

            excutePool.bioOps();
            System.out.println("第"+count+"次返回数据。"+"耗时："+(LocalDateTime.now().getSecond()-start.getSecond()));
            count++;
        }
    }

    /**
     * 模拟阻塞操作
     */
    private  void bioOps(){

        final int[] i = {0};

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000l);
                    i[0] =1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }


}
