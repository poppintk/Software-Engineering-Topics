package unionfind;
// 万能union find 模版
 class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        int converttoId(int x, int y, int m) {
             return x * m + y;
        }
        UnionFind(int n, int m) {
            for (int i = 0 ; i < n; i++) {
                for (int j = 0 ; j < m; j++) {
                    int id = converttoId(i,j,m);
                    father.put(id, id); 
                }
            }
        }
        int compressed_find(int x) {
            int parent =  father.get(x);
            while (parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            int temp = -1;
            int fa = x;
            while (fa!=father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent) ;
                fa = temp;
            }
            return parent;
        }
        
        void union(int x, int y) {
            int fa_x = compressed_find(x);
            int fa_y = compressed_find(y);
            if (fa_x != fa_y)
                father.put(fa_x, fa_y);
        }
    }



public class UnionFind {

    int count;

    int[] ranks;

    int[] parents;

    public UnionFind(int n) {
        this.count = n;
        this.ranks = new int[n];
        this.parents = new int[n];

        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
    }

    /**
     * During the find, we use path compression
     * @param p
     * @return
     */
    public int find(int p){
        if(parents[p] == p) return p;
        return parents[p] = find(parents[p]);
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ) return;

        if(ranks[rootP] > ranks[rootQ]){
            parents[rootQ] = rootP;
        }else if(rootQ < ranks[rootP]){
            parents[rootQ] = rootP;
        }else{
            parents[rootP] = rootQ;
            ranks[rootQ]++;
        }
        count--;
    }

}
