package algorithm.leetcode;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/7/3 12:14
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int[] colorsCount = {0,0,0};
        for (int i = 0; i < nums.length; i++) {
            assert nums[i] >= 0 && nums[i] <=2;
            colorsCount[nums[i]] += 1;
        }

        int index = 0;
        for (int i = 0; i < colorsCount[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < colorsCount[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < colorsCount[2]; i++) {
            nums[index++] = 2;
        }
    }

    public void sortColors2(int[] nums) {
        int zero = -1;  // [0,zero] is 0
        int two = nums.length;  // [two ,nums-1] is 2
        for (int i = 0; i < two;) {
            if (nums[i] == 2){
                two--;
                int tmp = nums[two];
                nums[two] = nums[i];
                nums[i] = tmp;
            }else if (nums[i] == 1){
                i ++;
            }else {
                zero ++;
                int tmp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = tmp;
                i ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {2,0,2,1,1,0};
        new SortColors().sortColors2(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
