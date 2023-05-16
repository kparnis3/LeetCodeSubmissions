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

// Time Complexity O(n) (only looping once)
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        // Using a dummy pointer at the beggining to help with pointer manipulation.
        
        //We dont care about the value for dummy pointer.
        ListNode dummyPointer = new ListNode(0, head);
        
        //|    |
        //v    V
        //0 -> 1 -> 2 -> 3 -> 4
        ListNode prevPointer = dummyPointer;
        ListNode currPointer = head;
        
        while (currPointer!=null && currPointer.next!=null)
        {
             // Get next pair
             ListNode nextPointer = currPointer.next.next; //Starting from three
             ListNode secondPointer = currPointer.next; // Retriving second pair
            
             // reverse pair
             secondPointer.next = currPointer; //swap
             currPointer.next = nextPointer;   //Set curr to next
             prevPointer.next = secondPointer; //swap
            
             // update pointers
             prevPointer = currPointer;
             currPointer = nextPointer;
        }
        
        return dummyPointer.next;
    }
        
}