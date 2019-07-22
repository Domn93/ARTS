package algorithm.leetcode;

import java.util.List;

/**
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *      cur node1 node2 next
 * dummyHead->1->2->3->4
 * node1.next = next.next;
 * node2.next = node1;
 * cur.next = node2;
 *
 * cur = node2;
 *
 * @author maqingze
 * @version v1.0
 * @date 2019/7/22 11:34
 */


class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null){
            ListNode node1 = cur.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            node2.next = node1;
            node1.next = next;
            cur.next = node2;
            cur = node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = createNode(new int[]{1, 2, 3, 4});
        printNode(node);
        ListNode node1 = swapPairs(node);
        printNode(node1);

    }
    private static ListNode createNode(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("arr can not be empty");
        }
        ListNode ret = new ListNode(-1);
        ListNode curNode = new ListNode(arr[0]);
        ret = curNode;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return ret;
    }

    private static void printNode(ListNode node){
        while (node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }
}
