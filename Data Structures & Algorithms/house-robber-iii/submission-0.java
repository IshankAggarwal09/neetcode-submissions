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
    public int[] travel(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] leftNodeChoices = travel(root.left);
        int[] rightNodeChoices = travel(root.right);
        int rob = root.val + leftNodeChoices[1] + rightNodeChoices[1];
        int notRob = Math.max(leftNodeChoices[0], leftNodeChoices[1]) + Math.max(rightNodeChoices[0], rightNodeChoices[1]);
        return new int[]{rob, notRob};
    }
    public int rob(TreeNode root) {
        int[] options = travel(root);
        return Math.max(options[0], options[1]);
    }
}