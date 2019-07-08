package algorithm.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/7/1 17:47
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> deWeighting = new HashSet();
        for (int i1 : nums1) {
            deWeighting.add(i1);
        }

        HashSet<Integer> retSet = new HashSet();
        for (int i1 : nums2) {
            if (deWeighting.contains(i1)) {
                retSet.add(i1);
            }
        }
        int[] ints = new int[retSet.size()];
        int c = 0;
        for (int s : retSet){
            ints[c++] = s;
        }

        return ints;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        System.out.println(new IntersectionOfTwoArrays().intersection(nums1,nums2));
    }
}
