package algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/7/6 11:36
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                ret[0] = map.get(target-nums[i]);
                ret[1] = i;
                return ret;
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
