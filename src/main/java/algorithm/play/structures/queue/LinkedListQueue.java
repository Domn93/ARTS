package algorithm.play.structures.queue;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/3/5 19:39
 */
public class LinkedListQueue<E> implements Queue<E> {
    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        size--;
        if (head == null){
            tail = null;
        }
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        return head.e;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            res.append(cur+"->");
        }
        res.append("NULL");
        return res.toString();
    }

    private class Node {
        public E e;
        public Node next;

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        Node(E e) {
            this(e, null);
        }

        Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
        }
        for (int i = 0; i < 11; i++) {
            linkedListQueue.dequeue();
            System.out.println(linkedListQueue);
        }
    }

}
