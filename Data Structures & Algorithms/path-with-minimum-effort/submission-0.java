class Pair {
    int effort;
    int row;
    int col;
    Pair(int effort, int row, int col) {
        this.effort = effort;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        pq.offer(new Pair(0, 0, 0));
        dist[0][0] = 0;
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, -1, 0, 1};
        while (!pq.isEmpty()) {
            int effort = pq.peek().effort;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.poll();
            if (effort > dist[row][col]) {
                continue;
            }
            for (int k=0; k<4; k++) {
                int nr = row + dr[k];
                int nc = col + dc[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int edge = Math.abs(heights[row][col] - heights[nr][nc]);
                    int newEffort = Math.max(effort, edge);
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.offer(new Pair(newEffort, nr, nc));
                    }
                }
            }
        }
        return dist[n-1][m-1];   
    }
}