package algorithm.leetcode;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/6/25 13:13
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int k = 0;
        // 保证在 [0,k) 非0
        // 在 [k,i) 为0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int t = nums[k];
                nums[k] = nums[i];
                nums[i] = t;
                k++;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(ints);
        for (int i = 0; i <ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
