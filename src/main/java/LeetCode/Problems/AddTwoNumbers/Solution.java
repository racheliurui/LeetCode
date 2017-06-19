package LeetCode.Problems.AddTwoNumbers;

import LeetCode.Problems.AddTwoNumbers.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode = null;
        ListNode resultNode = null;

        ListNode currentL1 = l1;
        ListNode currentL2 = l2;

        boolean extra = false;
        if (currentL1 != null && currentL2 != null)
            resultNode = new ListNode(currentL1.val + currentL2.val);
        if (resultNode.val >= 10) {
            resultNode.val = resultNode.val - 10;
            extra = true;
        }
        currentNode = resultNode;
        currentL1 = currentL1.next;
        currentL2 = currentL2.next;

        while (currentL1 != null || currentL2 != null || extra) {
            currentNode.next = new ListNode(((currentL1 == null) ? 0 : currentL1.val) + ((currentL2 == null) ? 0 : currentL2.val) + ((extra) ? 1 : 0));
            currentNode = currentNode.next;
            if (currentNode.val >= 10) {
                currentNode.val = currentNode.val - 10;
                extra = true;
            } else
                extra = false;
            if (currentL1 != null & currentL1.next != null)
                currentL1 = currentL1.next;
            else
                currentL1 = null;
            if (currentL2 != null & currentL2.next != null)
                currentL2 = currentL2.next;
            else
                currentL2 = null;
        }


        return resultNode;
    }
}