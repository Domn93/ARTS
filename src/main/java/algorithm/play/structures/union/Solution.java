package algorithm.play.structures.union;

import java.util.Random;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/5/31 12:28
 */
public class Solution {

    private static double testUF(UF uf, int m){

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();


        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        return time;
    }

    public static void main(String[] args) {

        int size = 10000000;
        int m = 10000000;

        UnionFind uf5 = new UnionFind(size);
        System.out.println("UnionFind : " + testUF(uf5, m) + " s");
    }
}
