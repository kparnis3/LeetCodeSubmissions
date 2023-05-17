/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // O(n)
    public int pairSum(ListNode head) {
        /*
            5 -> 4 -> 2 -> 1        4 -> 2 -> 2 -> 3
            
            5+1 = 6 Max             4+3 = 7 max
            4+2 = 6                 2+2 = 4
                  6                       7
                  
            Approach  
            1) traverse till we find the middle of the linked list (using slow and fast pointers)
            2) reverse the pointers of the first half s.t 5 <- 4 , 2 -> 1
            3) using ref from the middle two compute max twin sum
                 
        */
        
        ListNode slow = head;
        ListNode fast = head;
        int result = 0;
        ListNode prev = null;
        
        while (fast!=null && fast.next!=null){
            fast = fast.next.next; // shift twice

            ListNode temp = slow.next;
            slow.next = prev; //switch pointer
            prev = slow;
            slow = temp;
        }
        
        while (slow!=null){ //Linked list is even
            result = Math.max(result, prev.val + slow.val); //Prev -> left side, 
            prev = prev.next;                               //Slow -> right side
            slow = slow.next;
        }
        
        return result;
    }
}