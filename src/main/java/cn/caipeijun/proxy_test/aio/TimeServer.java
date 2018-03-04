package cn.caipeijun.proxy_test.aio;

/**
 * Created by pc on 2015/1/5.
 */
public class TimeServer {


    public static void main(String[] args) {

        String property = System.getProperty("line.separator");

        System.out.println(property.length());

        for(char x : property.toCharArray()){
            System.out.println(x);
        }

    }


}