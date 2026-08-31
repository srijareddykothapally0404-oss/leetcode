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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
         int first = -1;
        int prevCritical = -1;
        int minDistance = Integer.MAX_VALUE;
        int position = 1;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null && curr.next != null) {

            // Check if curr is a critical point
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                // First critical point
                if (first == -1) {
                    first = position;
                }

                // We already have a previous critical point
                if (prevCritical != -1) {
                    minDistance = Math.min(
                        minDistance,
                        position - prevCritical
                    );
                }

                prevCritical = position;
            }

            prev = curr;
            curr = curr.next;
            position++;
        }

        // Fewer than two critical points
        if (first == -1 || first == prevCritical) {
            return new int[]{-1, -1};
        }

        int maxDistance = prevCritical - first;

        return new int[]{minDistance, maxDistance};
    }
}