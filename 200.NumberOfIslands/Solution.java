public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int w = grid.length, h = grid[0].length, waterCount = 0;
        
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(w * h);
        for(int i = 0; i < w; i++) {
            for(int j = 0; j < h; j++) {
                if(grid[i][j] == '0') {
                    waterCount++;
                } else {
                    int currIdx = i * h + j;
                    if(i < w - 1 && grid[i + 1][j] == '1') {
                        uf.union(currIdx, currIdx + h); 
                    }
                    if(j < h - 1 && grid[i][j + 1] == '1') {
                        uf.union(currIdx, currIdx + 1);
                    }
                }
            }
        }
        return uf.count() - waterCount;
    }
    private class WeightedQuickUnionUF {
        int count;
        int[] sz, id;
        public WeightedQuickUnionUF(int N) {
            sz = new int[N];
            id = new int[N];
            count = N;
            for(int i = 0; i < id.length; i++) {
                id[i] = i;
            }
        }
        public int find(int p){ 
            while(p != id[p]) p = id[p];
            return p;
        }
        public int count() {
            return count;
        }
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
        public void union(int p, int q) {
            int pId = find(p), qId = find(q);
            if(pId == qId) return;
            if(sz[pId] < sz[qId]) {
                id[pId] = qId;
                sz[qId] += sz[pId];
            } else {
                id[qId] = pId;
                sz[pId] += sz[qId];
            }
            count--;
        }
    }
}
