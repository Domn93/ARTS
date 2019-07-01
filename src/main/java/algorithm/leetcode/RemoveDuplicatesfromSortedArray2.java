package algorithm.leetcode;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/6/25 14:02
 */
public class RemoveDuplicatesfromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int writeIndex = 0;

        for(int i = 0; i < nums.length; i++){

            if(i <2 || nums[writeIndex-2] != nums[i]){
                nums[writeIndex++] = nums[i];

            }
        }

        return writeIndex;
    }

    public static void main(String[] args) {
        int[] ints = {0, 0, 1, 1, 1, 2, 2, 2, 3, 4};
        int i = new RemoveDuplicatesfromSortedArray2().removeDuplicates(ints);
        System.out.println("return is "+i);
        for (int j = 0; j < ints.length; j++) {
            System.out.println(ints[j]);
        }
    }
}
