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
   public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next != null && fast.next.next == null){
            deleteNextNode(slow);
        }else{
            deleteNextNode(prev);
        }
        return head;
    }

    public void deleteNextNode(ListNode prev) {
        ListNode pointer = prev.next.next;
        prev.next.next = null;
        prev.next = pointer;
    }
}