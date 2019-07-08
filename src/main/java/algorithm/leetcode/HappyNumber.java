package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/7/6 11:13
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> happySet = new HashSet<>();
        while (n != 1){
            int next = getNext(n);
            if (happySet.contains(next)){
                return false;
            }
            happySet.add(next);
            n = next;
        }
        return true;
    }

    private int getNext(int x) {
        int ret = 0;
        while(x != 0 ){
            ret += (x%10) * (x%10);
            x = x / 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        boolean happy = new HappyNumber().isHappy(19);
        System.out.println(happy);
    }
}
