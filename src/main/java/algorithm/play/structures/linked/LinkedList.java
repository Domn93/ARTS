package algorithm.play.structures.linked;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/2/28 12:44
 */
public class LinkedList<E> {


    /**
     * Node数据内部类
     */
    class Node {
        private E e;
        private Node next;

        public Node(E e, Node node) {
            this.e = e;
            this.next = node;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 虚拟头结点
     */
    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 根据索引添加元素
     *
     * @param index 这里的索引仅供学习思考使用 无生产意义
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed , index is not valid");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }


    // 获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed , index is not valid");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur.e != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed , index is not valid");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }


    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            Node cur = prev.next;
            if (cur.e.equals(e)) {
                break;
            }
            prev = cur;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            size--;
            delNode.next = null;
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }
}
