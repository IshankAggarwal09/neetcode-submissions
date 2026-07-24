class Solution {

    private int[] par;

    public int find(int x) {
        if (x != par[x]) {
            par[x] = find(par[x]);
        }
        return par[x];
    }
    public void union(int x, int y) {
        par[find(y)] = find(x);
    }
    public int[] findRedundantConnection(int[][] edges) {
        par = new int[edges.length + 1];
        for (int i=0; i<par.length; i++) {
            par[i] = i;
        }
        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return edge;
            }
            else {
                union(edge[0], edge[1]);
            }
        }
        return edges[0];
    }
}