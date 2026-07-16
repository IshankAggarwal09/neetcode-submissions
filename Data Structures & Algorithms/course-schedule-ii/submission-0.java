class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = numCourses;
        for (int i=0; i<V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];
        for (int i=0; i<V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        for (int i=0; i<V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        if (topo.size() != V) {
            return new int[0];
        }
        int[] ans = new int[V];
        for (int i=0; i<V; i++) {
            ans[i] = topo.get(i);
        }
        return ans;
    }
}