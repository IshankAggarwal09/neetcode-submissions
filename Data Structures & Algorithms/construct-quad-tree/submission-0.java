/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int row, int col, int size) {
        if (isSame(grid, row, col, size)) {
            return new Node(grid[row][col] == 1, true);
        }
        else {
            Node root = new Node(true, false);
            root.topLeft = build(grid, row, col, size/2);
            root.topRight = build(grid, row, col+size/2, size/2);
            root.bottomLeft = build(grid, row+size/2, col, size/2);
            root.bottomRight = build(grid, row+size/2, col+size/2, size/2);
            return root;
        }
    }

    private boolean isSame(int[][] grid, int row, int col, int size) {
        int value = grid[row][col];
        for (int i=row; i<row+size; i++) {
            for (int j=col; j<col+size; j++) {
                if (grid[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}