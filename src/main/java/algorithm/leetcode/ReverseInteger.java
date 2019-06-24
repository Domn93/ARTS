package algorithm.leetcode;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/6/20 12:25
 */
class ReverseInterger {
    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1;
        int ret = 0;
        int tmp = Math.abs(x);
        while (tmp > 0) {
            if (ret > Integer.MAX_VALUE / 10){
                return 0;
            }
            ret = ret * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        ret = ret * sign;
        return ret;

    }

    public static void main(String[] args) {
//        System.out.println(new ReverseInterger().reverse(123));
//        System.out.println(new ReverseInterger().reverse(-123));
//        System.out.println(new ReverseInterger().reverse(-120));
        System.out.println(new ReverseInterger().reverse(1534236469));
    }
}
