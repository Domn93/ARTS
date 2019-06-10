package algorithm.play.structures.union;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/5/31 12:12
 */
public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
