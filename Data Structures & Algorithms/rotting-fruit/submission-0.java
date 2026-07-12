class Pair {
    int first;
    int second;
    int time;
    Pair(int first, int second, int time) {
        this.first = first;
        this.second = second;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        int countFresh = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }
        int time = 0;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int count = 0;
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int t = q.peek().time;
            time = Math.max(time, t);
            q.remove();
            for (int k=0; k<4; k++) {
                int nRow = row + delRow[k];
                int nCol = col + delCol[k];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
                    vis[nRow][nCol] = 2;
                    q.add(new Pair(nRow, nCol, t+1));
                    count++;
                }
            }
        }
        if (count != countFresh) {
            return -1;
        }
        return time;
    }
}