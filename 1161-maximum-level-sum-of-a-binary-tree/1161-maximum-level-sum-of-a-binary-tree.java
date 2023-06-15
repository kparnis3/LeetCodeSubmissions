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
    public int maxLevelSum(TreeNode root) {
        //Via BFS, Time: O(n)
        
        int maxSum = Integer.MIN_VALUE;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int level = 0;
        int result = 0;
        
        while(!queue.isEmpty()){
            level++;
            int sum = 0;
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                
                if(node.left!=null){ //Add left and right to be explored.
                    queue.offer(node.left);
                    
                }
                
                if(node.right!=null){
                    queue.offer(node.right);
                }
                 
            }
            
            //System.out.println("Level: "+level+" Sum: "+sum);
            
            if(sum > maxSum){
                maxSum = sum;
                result = level;
            }
            
            
        }
        
        return result;
    }
}