package algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/7/6 12:13
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0){
            return false;
        }
        HashMap<Long,Integer> map = new HashMap<>();
        for (int n = 0; n < nums.length; n++) {
            if (map.containsValue(nums[n])) {
                return true;
            }
            if ( map.size() == k) {
               map.remove((long)(n-k));
            }
            map.put((long) n,nums[n]);
        }

        return false;
    }

    public static void main(String[] args) {
        boolean b = new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2);
        System.out.println(b);
    }
}
