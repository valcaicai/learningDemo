package cn.caipeijun.proxy_test.synchronizedTest;

import java.util.concurrent.CountDownLatch;

/**
 * <p/>
 * 多线程卖票
 * @author <a href="pigeon@kingyon.com">Pigeon</a>
 * caipeijun
 * 2018/3/1
 * @since 0.1.0
 */
public class SynchronizedTest {


    public int num = 10000;

    public void sell(){
        synchronized (this){
            num--;
        }
    }

    public void sellWithOutSynchronized(){

        for(int i=0;i<1000;i++){
            new Thread(()->{
                while(this.num>0){
                    try {
                        Thread.sleep(1l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"卖出一张票,余"+num);
                    num-=1;
                }
            }).run();
        }

    }

    public void sellWithSynchronized(){

        for(int i=0;i<1000;i++){
            new Thread(()->{
                while(this.num>0){
                    System.out.println(Thread.currentThread().getName()+"卖出一张票");
                    sell();
                }
            }).run();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        SynchronizedTest synchronizedTest = new SynchronizedTest();

        synchronizedTest.sellWithOutSynchronized();

//        Thread.sleep(1000);

        System.out.println(synchronizedTest.num);


    }

}
