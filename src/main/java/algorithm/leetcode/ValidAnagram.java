package algorithm.leetcode;

import java.util.HashMap;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/7/2 19:12
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> wordRequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (wordRequency.get(c) == null){
                wordRequency.put(c,1);
            }else {
                wordRequency.put(c,wordRequency.get(c)+ 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer frec = wordRequency.get(c);
            if (frec == null){
                return false;
            }
            if (frec > 0){
                wordRequency.put(c,--frec);
                if (frec == 0){
                    wordRequency.remove(c);
                }
            }
        }
        return wordRequency.isEmpty();
    }

    public static void main(String[] args) {
        String s = "anagr1am";
        String t = "nagaram";
        System.out.println(new ValidAnagram().isAnagram(s,t));
    }
}
