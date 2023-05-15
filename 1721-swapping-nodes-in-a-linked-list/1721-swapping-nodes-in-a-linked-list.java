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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        List<Integer> values = new ArrayList();
        
        // Get all the elements and put them in a list
        while(temp!=null){
            values.add(temp.val);
            temp = temp.next;
        }
        
        // Swap the elements
        int val1 = 0;
        val1 = values.get(k-1);
        int val2 = values.get(values.size()-k);
        
        values.set(k-1, val2);
        values.set(values.size()-k, val1);
        
        // Rebuild linked list
        temp = head;
        int i = 0;
        while(temp!=null){
            temp.val = values.get(i);
            temp = temp.next;
            i++;
        }
        
        
        
        return head;
    }
}