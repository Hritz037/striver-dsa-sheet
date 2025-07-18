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
//Points to be noted:
//1. Logic same as LCA
// Do DFS traversal
//Keep a global variable for answer
//Have to include root.val in ans because if not then the children already contain those values
//you can add either value from left subtree or rightsubtree or no subtree at all.
class Solution {
    public int pathsum;
    public int traverse(TreeNode root){
        if(root==null)return 0;
        int left=traverse(root.left);
        int right=traverse(root.right);
        int ans=root.val+(left<=0?0:left)+(right<=0?0:right);
        pathsum=Math.max(pathsum,ans);
        return root.val+Math.max(left,Math.max(right,0));
    }
    public int maxPathSum(TreeNode root) {
        pathsum=Integer.MIN_VALUE;
        traverse(root);
        return pathsum;
    }
}