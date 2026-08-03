class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // Save next node
            curr.next = prev;          // Reverse pointer
            prev = curr;               // Move prev
            curr = next;               // Move curr
        }
        return prev; // New head
    }
}