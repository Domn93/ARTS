package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/7/1 17:47
 */
public class IntersectionOfTwoArrays2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                Integer n = map.get(nums1[i]);
                map.put(nums1[i], n + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        ArrayList<Integer> retList = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.get(nums2[i]) != null && map.get(nums2[i])> 0){
                retList.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }
        int[] ints = new int[retList.size()];
        int x = 0;
        for(int s : retList){
            ints[x++] = s;
        }

        return ints;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] intersection = new IntersectionOfTwoArrays2().intersection(nums1, nums2);
        for (int i = 0; i < intersection.length; i++) {
            System.out.println(intersection[i]);
        }
    }
}
