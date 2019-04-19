package algorithm.play.structures.queue;

import algorithm.play.structures.heap.MaxHeap;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/4/19 14:44
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        this.maxHeap = new MaxHeap();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
