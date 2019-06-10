package algorithm.play.structures.union;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/5/31 12:12
 */
public class UnionFind implements UF{

    private int[] rank;
    private int[] parent;

    UnionFind(int size){
        rank = new int[size];
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p){
        if(p < 0 || p >= parent.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot ){
            return;
        }

        if (rank[pRoot] < rank[qRoot]){
            parent[pRoot] = parent[qRoot];
        }else if (rank[qRoot] < rank[pRoot]){
            parent[qRoot] = parent[pRoot];
        }else {
            parent[pRoot] = parent[qRoot];
            rank[qRoot] += 1;
        }
    }
}
