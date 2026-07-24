class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i=0; i<n; i++) {
            if (!pacific[i][0]) {
                dfs(heights, i, 0, pacific, dx, dy, n, m);
            }
        }
        for (int j=0; j<m; j++) {
            if (!pacific[0][j]) {
                dfs(heights, 0, j, pacific, dx, dy, n, m);
            }
        }
        for (int i=0; i<n; i++) {
            if (!atlantic[i][m - 1]) {
                dfs(heights, i, m - 1, atlantic, dx, dy, n, m);
            }
        }
        for (int j=0; j<m; j++) {
            if (!atlantic[n - 1][j]) {
                dfs(heights, n - 1, j, atlantic, dx, dy, n, m);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] heights, int i, int j, boolean[][] vis, int[] dx, int[] dy, int n, int m) {
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (isValid(x, y, n, m) && heights[x][y] >= heights[i][j] && !vis[x][y]) {
                dfs(heights, x, y, vis, dx, dy, n, m);
            }
        }
    }
    public boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}