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
    public List<Integer> rightSideView(TreeNode root) {
        return helper(root, 0, new ArrayList<>());
    }
    private List<Integer> helper(TreeNode node, int level, List<Integer> view) {
        if (node == null) return view;
        if (level == view.size()) view.add(node.val);
        helper(node.right, level + 1, view);
        helper(node.left, level + 1, view);
        return view;
    }
}
