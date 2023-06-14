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
    public int getMinimumDifference(TreeNode root) {
        //Inorder Traversal
        
        int result = Integer.MAX_VALUE; //set result to max int value to minimise 
        
        int previous = -1;
        
        Deque<TreeNode> queue = new ArrayDeque<>(); //Create Stack
        
        while(!queue.isEmpty() || root!=null){ 
            
            while(root!=null){
                queue.push(root);
                root = root.left;
            }
            
            root = queue.pop(); //pop root node
            
            if(previous >= 0){ //Check Minimum absolute diff between current result and two vals
                result = Math.min(result, root.val - previous);
            }
            
            previous = root.val;
            root = root.right;
        }
        
        return result;
    }
}