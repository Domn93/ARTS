package algorithm.leetcode;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/6/25 13:42
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0; // 在 [0,k)非val [k,i)为val
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                int t = nums[i];
                nums[i] = nums[k];
                nums[k] = t;
                k ++ ;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 2, 2, 3, 0, 4, 2};
        int i = new RemoveElement().removeElement(ints, 2);
        System.out.println("return length is " + i);
        for (int j = 0; j < ints.length; j++) {
            System.out.println(ints[j]);
        }
    }
}
