class Solution {
    public ListNode swapPairs(ListNode head) {

        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {

            // First and second nodes
            ListNode first = prev.next;
            ListNode second = first.next;

            // Swap
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move to next pair
            prev = first;
        }

        return dummy.next;
    }
}