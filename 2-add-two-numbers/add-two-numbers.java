
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // A dummy node to serve as the anchor for our result list
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // Loop continues as long as there's a digit to process or a carry-over remaining
        while (l1 != null || l2 != null || carry != 0) {
            // Extract values, use 0 if the list has reached its end
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate sum and update the carry
            int sum = val1 + val2 + carry;
            carry = sum / 10;

            // Append the new digit to the result list
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Move to the next nodes in the input lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // The actual head of our sum list starts right after the dummy node
        return dummyHead.next;
    }
}