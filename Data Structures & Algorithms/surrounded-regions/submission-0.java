class Solution {
    public void dfs(int row, int col, int[][] vis, char[][] board, int[] delRow, int[] delCol) {
        vis[row][col] = 1;
        int m = board.length;
        int n = board[0].length;
        for (int k=0; k<4; k++) {
            int nRow = row + delRow[k];
            int nCol = col + delCol[k];
            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0 && board[nRow][nCol] == 'O') {
                dfs(nRow, nCol, vis, board, delRow, delCol);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        for (int j=0; j<n; j++) {
            if (vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, vis, board, delRow, delCol);
            }
            if (vis[m-1][j] == 0 && board[m-1][j] == 'O') {
                dfs(m-1, j, vis, board, delRow, delCol);
            }
        }
        for (int i=0; i<m; i++) {
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, vis, board, delRow, delCol);
            }
            if (vis[i][n-1] == 0 && board[i][n-1] == 'O') {
                dfs(i, n-1, vis, board, delRow, delCol);
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}