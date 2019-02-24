package jmx;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/2/19 15:22
 */
public class JMXClient {
    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 9999;
        String url = "service:jmx:rmi:///jndi/rmi://"+host+":"+port+"/jmxrmi";
        JMXServiceURL serviceURL = new JMXServiceURL(url);
        JMXConnector connect = JMXConnectorFactory.connect(serviceURL);
        MBeanServerConnection connection = connect.getMBeanServerConnection();
        //使用JMXConnectorFactory 方式连接时，JMXServiceURL 的参数 url 必须使用 service:jmx 方式进行连接，
        // 通过上面这种方式，我们得到了一个 JMX 客户端和服务器直接的连接 connection。
//        printAllMsg(connection);

        ObjectName objectName = new ObjectName("jmx:type=Hello");
        getSpecifiedObject(connection,objectName);
    }

    /**
     * print all jmx information contains a lot of jvm messages
     * @param connection
     * @throws IOException
     * @throws InstanceNotFoundException
     * @throws IntrospectionException
     * @throws ReflectionException
     */
    private static void printAllMsg(MBeanServerConnection connection) throws IOException, InstanceNotFoundException, IntrospectionException, ReflectionException {
        Set<ObjectName> objectNames = connection.queryNames(null, null);
        for (ObjectName objectName : objectNames) {
            System.out.println("========" + objectName + "========");
            MBeanInfo mBeanInfo = connection.getMBeanInfo(objectName);
            System.out.println("[Attributes]");
            for (MBeanAttributeInfo attr : mBeanInfo.getAttributes()) {
                Object value = null;
                try {
                    value = attr.isReadable() ? connection.getAttribute(objectName, attr.getName()) : "";
                } catch (Exception e) {
                    value = e.getMessage();
                }
                System.out.println(attr.getName() + ":" + value);
            }
            System.out.println("[Operations]");
            for (MBeanOperationInfo oper : mBeanInfo.getOperations()) {
                System.out.println(oper.getName() + ":" + oper.getDescription());
            }
            System.out.println("[Notifications]");
            for (MBeanNotificationInfo notice : mBeanInfo.getNotifications()) {
                System.out.println(notice.getName() + ":" + notice.getDescription());
            }
        }
    }

    private static void getSpecifiedObject(MBeanServerConnection connection, ObjectName objectName) throws Exception {
        connection.addNotificationListener(objectName, new NotificationListener() {
            @Override
            public void handleNotification(Notification notification, Object handback) {
                System.out.println("\nReceived notification:");
                System.out.println("\tClassName: " + notification.getClass().getName());
                System.out.println("\tSource: " + notification.getSource());
                System.out.println("\tType: " + notification.getType());
                System.out.println("\tMessage: " + notification.getMessage());
                if (notification instanceof AttributeChangeNotification) {
                    AttributeChangeNotification acn =
                            (AttributeChangeNotification) notification;
                    System.out.println("\tAttributeName: " + acn.getAttributeName());
                    System.out.println("\tAttributeType: " + acn.getAttributeType());
                    System.out.println("\tNewValue: " + acn.getNewValue());
                    System.out.println("\tOldValue: " + acn.getOldValue());
                }
            }
        }, null, null);

        Object cacheSize = connection.getAttribute(objectName, "CacheSize");
        System.out.println("Get Value: " + cacheSize);

        connection.setAttribute(objectName, new Attribute("CacheSize", 100));

        connection.invoke(objectName, "sayHello", null, null);
        Object result = connection.invoke(objectName, "add",
                new Object[]{1, 9},
                new String[]{int.class.getCanonicalName(), int.class.getCanonicalName()});
        System.out.println("1 + 9 = " + result);
    }
}
