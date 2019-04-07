package algorithm.play.structures.map;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/4/2 18:27
 */
public interface Map<K, V> {

    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();
}
