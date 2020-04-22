package unionfind;

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
