package algorithm.play.structures.map;

import algorithm.play.structures.utils.FileOperation;

import java.util.ArrayList;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/4/2 18:28
 */
public class LinkedListMap<K,V> implements Map<K,V> {

    private class Node{
        private K key;
        private V value;
        private Node next;

        public Node(K key,V value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value){
            this(key, value, null);
        }

        public Node(){
            this(null, null, null);
        }

        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyNode;
    private int size;

    LinkedListMap(){
        this.dummyNode = new Node();
        this.size = 0;
    }

    private Node getNode(K key){
        Node cur = dummyNode.next;
        while (cur != null){
            if (cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (null == node){
            Node cur = dummyNode.next;
            Node newNode = new Node(key, value, cur);
            dummyNode.next = newNode;
            size++;
        }else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    @Override
    public V get(K key) {
        Node cur = getNode(key);
        return cur==null?null:cur.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node == null){
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("src/main/java/algorithm/play/structures/data/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
