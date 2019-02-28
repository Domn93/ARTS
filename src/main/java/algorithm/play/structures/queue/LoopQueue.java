package algorithm.play.structures.queue;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/2/26 12:45
 */
public class LoopQueue<E> implements Queue<E> {
    private E data[];
    private int front, tail;
    private int size;

    LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    LoopQueue() {
        this(8);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }


    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E ret = data[front];
        front = (front + 1) % data.length;
        size --;
        if (size == getCapacity()/4 && getCapacity() /2 != 0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        return null;
    }


    private void resize(int capacity) {
        E newData[] = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LoopQueue: ");
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("[");
        for (int i = front ; i != tail ;i = (i+1)%data.length){
            res.append(data[i]);
            if (i!=tail -1){
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){

        LoopQueue<Integer> queue = new LoopQueue(4);
        for(int i = 0 ; i < 200 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
