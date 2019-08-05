package algorithm.leetcode;


/**
 * @author maqingze
 * @version v1.0
 * @date 2019/8/1 17:02
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right =t5;
        MaximumDepthofBinaryTree maximumDepthofBinaryTree = new MaximumDepthofBinaryTree();
        int i = maximumDepthofBinaryTree.maxDepth(t1);
        System.out.println(i);
    }

}
