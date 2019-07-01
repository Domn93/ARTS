package algorithm.leetcode;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/6/25 14:02
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int k = 1;
        int val = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[k] = nums[i];
                k ++ ;
                val = nums[i];
            }

        }
        return k;
    }

    public static void main(String[] args) {
        int[] ints = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = new RemoveDuplicatesfromSortedArray().removeDuplicates(ints);
        System.out.println("return is "+i);
        for (int j = 0; j < ints.length; j++) {
            System.out.println(ints[j]);
        }
    }
}
