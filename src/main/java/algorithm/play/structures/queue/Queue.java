package algorithm.play.structures.queue;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/2/26 11:01
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
