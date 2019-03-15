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

    BST() {
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
        add(root, e);
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

    public void preOrder(E e) {
        preOrder(root, e);
    }

    private void preOrder(Node node, E e) {
        if (null == node) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left, e);
        preOrder(node.right, e);
    }

    public void inOrder(E e) {
        inOrder(root, e);
    }

    private void inOrder(Node node, E e) {
        if (null == node) {
            return;
        }
        preOrder(node.left, e);
        System.out.println(node.e);
        preOrder(node.right, e);
    }


    public void postOrder(E e) {
        postOrder(root, e);
    }

    private void postOrder(Node node, E e) {
        if (null == node) {
            return;
        }
        preOrder(node.left, e);
        preOrder(node.right, e);
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

    public void levelOrder(E e){
        LinkedListQueue<Node> queue = new LinkedListQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()){
            Node node = queue.dequeue();
            System.out.println(node.e);
            if (null != node.left){
                queue.enqueue(node.left);
            }
            if (null != node.right){
                queue.enqueue(node.right);
            }
        }
    }


}
