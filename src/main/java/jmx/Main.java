package jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/2/19 14:38
 *
 * jvm参数
 * -Dcom.sun.management.jmxremote.port=9999
 * -Dcom.sun.management.jmxremote.authenticate=false
 * -Dcom.sun.management.jmxremote.ssl=false
 * jconsole 可以通过 ip:port连接 或者通过rmi协议连接
 * service:jmx:rmi:///jndi/rmi://127.0.0.1:9999/jmxrmi
 *  参考https://blog.csdn.net/isea533/article/details/77431044
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName mBeanName = new ObjectName("jmx:type=Hello");
        final Hello mBean = new Hello();
        mBeanServer.registerMBean(mBean, mBeanName);
        System.out.println("Waiting for requests ...");
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(()->{
            Random random = new Random();
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(random.nextInt(10));
                } catch (Exception e) {
                }
                mBean.setCacheSize(random.nextInt(10) + mBean.getCacheSize());
            }
        });
        Thread.sleep(Long.MAX_VALUE);
    }
}
