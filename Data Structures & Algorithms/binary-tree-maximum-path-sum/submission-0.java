/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
    public int solve (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = solve(root.left);
        int r = solve(root.right);
        int sum1 = l + r + root.val;
        int sum2 = Math.max(l, r) + root.val;
        int sum3 = root.val;
        maxSum = Math.max(maxSum, Math.max(sum1, Math.max(sum2, sum3)));
        return Math.max(sum2, sum3);
    }
}