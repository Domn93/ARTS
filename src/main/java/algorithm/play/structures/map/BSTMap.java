package algorithm.play.structures.map;

import algorithm.play.structures.utils.FileOperation;

import java.util.ArrayList;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/4/2 19:42
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    class Node {
        private Node left;
        private Node right;
        private K key;
        private V value;

        Node(K key, V value) {
            this.left = null;
            this.right = null;
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        add(key, value, root);
    }

    private Node add(K key, V value, Node node) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key)<0){
            node.left = add(key,value,node.left);
        }else if (key.compareTo(node.key)>0){
            node.right = add(key, value, node.right);
        }
        return node;
    }

    public K mininum(){
        if (size == 0){
            throw new IllegalArgumentException("BST MAP IS EMPTY");
        }
        Node miniNode = mininum(root);
        return miniNode.key;
    }

    private Node mininum(Node node){
        if (null==node.left){
            return node;
        }
        return mininum(node.left);
    }


    public K removeMininum(){
        K mininum = mininum();
        root = removeMininum(root);
        return mininum;
    }

    private Node removeMininum(Node node){
        if (node.left == null){
            Node ChildRight = node.right;
            node.right = null;
            size--;
            return ChildRight;
        }
        node.left = removeMininum(node.left);
        return node;

    }

    private Node getNode(Node node , K key){
        if (node == null){
            return  null;
        }
        if (key.equals(node.key)){
            return node;
        }else if (key.compareTo(node.key)<0){
            return getNode(node.left,key);
        }else {
            return getNode(node.right,key);
        }
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node!=null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){

        if( node == null )
            return null;

        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            return node;
        }
        else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
            return node;
        }
        else{   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = mininum(node.right);
            successor.right = removeMininum(node.right);
            successor.left = node.left;
            node.left = node.right = null;

            return successor;
        }
    }

    @Override
    public boolean contains(K key) {
        return false;
    }
    private boolean contains(Node node, K e) {
        if (null == node) {
            return false;
        }
        if (e.compareTo(node.key) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.key) > 0) {
            return contains(node.right, e);
        } else {
            return true;
        }
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node==null? null:node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (null == node){
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

            BSTMap<String, Integer> map = new BSTMap<>();
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
