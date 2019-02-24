package jmx;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/2/19 14:36
 */
public interface HelloMBean {
    public void sayHello();

    public int add(int x, int y);

    public String getName();

    public int getCacheSize();

    public void setCacheSize(int size);
}
