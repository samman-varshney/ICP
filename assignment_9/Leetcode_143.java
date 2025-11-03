package assignment_9;

public class Leetcode_143 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public void reorderList(ListNode head) {
            ListNode slow = head;
            ListNode fast = head.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode prev = slow, curr = slow.next, next;
            slow.next = null;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode d1 = head, d2 = prev;
            while (d1 != d2 && d1 != null) {
                ListNode temp1 = d1.next;
                ListNode temp2 = d2.next;

                d1.next = d2;
                d2.next = temp1;

                d1 = temp1;
                d2 = temp2;
            }
        }
    }
}

//tc: O(n)
//sc: O(1)

// Input: head = [1,2,3,4]
// Output: [1,4,2,3]
// Example 2:


// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]