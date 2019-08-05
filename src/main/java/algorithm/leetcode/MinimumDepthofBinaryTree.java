package algorithm.leetcode;


/**
 * @author maqingze
 * @version v1.0
 * @date 2019/8/1 17:02
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
//        TreeNode t3 = new TreeNode(20);
//        TreeNode t4 = new TreeNode(5);
//        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
//        t1.right = t3;
//        t3.left = t4;
//        t3.right =t5;
        MinimumDepthofBinaryTree maximumDepthofBinaryTree = new MinimumDepthofBinaryTree();
        int i = maximumDepthofBinaryTree.minDepth(t1);
        System.out.println(i);
    }

}
