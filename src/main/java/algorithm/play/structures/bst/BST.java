package algorithm.play.structures.bst;

import algorithm.play.structures.queue.LinkedListQueue;

import java.util.Stack;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/3/15 11:19
 */
public class BST<E extends Comparable<E>> {
    class Node {
        public E e;
        public Node left;
        public Node right;

        Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(E e) {
        root = add(root, e);
    }

    public Node add(Node node, E e) {
        if (null == node) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }


    public void preOrderNR(E e) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (null == node) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (null == node) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (null == node) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (null == node) {
            return false;
        }
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return true;
        }
    }

    public void levelOrder() {
        LinkedListQueue<Node> queue = new LinkedListQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            System.out.println(node.e);
            if (null != node.left) {
                queue.enqueue(node.left);
            }
            if (null != node.right) {
                queue.enqueue(node.right);
            }
        }
    }

    public E mininum() {
        if (size == 0) {
            throw new IllegalThreadStateException(" BST is empty");
        }
        Node minNode = mininum(root);
        return minNode.e;
    }

    private Node mininum(Node node) {
        if (null == node.left) {
            return node;
        }
        return mininum(node.left);
    }

    public E maxnum() {
        if (size == 0) {
            throw new IllegalThreadStateException(" BST is empty");
        }
        Node maxNode = maxnum(root);
        return maxNode.e;
    }

    private Node maxnum(Node node) {
        if (null == node.right) {
            return node;
        }
        return node.right;
    }

    public E removeMax() {
        E maxnum = maxnum();
        root = removeMax(root);
        return maxnum;
    }

    private Node removeMax(Node node) {
        if (null == node.right) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public E removeMin() {
        E minnum = mininum();
        root = removeMin(root);
        return minnum;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node childRight = node.right;
            node.right = null;
            size--;
            return childRight;

        }
        node.left = removeMin(node.left);
        return node;
    }


    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left,e);
            return node;
        }else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
            return node;
        }else {
            if (node.left == null){
                Node rightNode = node.right;
                size--;
                node.right = null;
                return rightNode;
            }
            if (node.right == null){
                Node leftNode = node.left;
                size--;
                node.left = null;
                return leftNode;
            }
            Node successor = removeMin(node.right);
            successor.left = node.left;
            successor.right = node.right;
            node.left = node.right = null;
            return successor;

        }


    }


    public static void main(String[] args) {
        BST<Integer> node = new BST();
        node.add(6);
        node.add(3);
        node.add(4);
        node.add(1);
        node.add(9);
        node.add(7);
        node.add(8);
        System.out.println(node.contains(4));
        System.out.println(node.contains(5));
        System.out.println("=========================");

//        node.levelOrder();

        System.out.println("=========================");
//        node.preOrder();

        System.out.println("=========================");
//        node.inOrder();

        System.out.println("=========================");
//        node.postOrder();
        System.out.println("=========================");
//        System.out.println(node.mininum());
//        System.out.println(node.maxnum());

        System.out.println("=========================");
        node.removeMax();
        node.inOrder();
        node.removeMax();
        node.inOrder();

    }
}
