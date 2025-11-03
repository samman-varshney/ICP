package assignment_9;

public class Leetcode_234 {
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
        ListNode head;

        public boolean helper(ListNode node) {
            if (node == null)
                return true;

            boolean res = helper(node.next);
            if (!res)
                return false;

            if (head.val == node.val) {
                head = head.next;
                return true;
            }
            return false;
        }

        public boolean isPalindrome(ListNode node) {
            this.head = node;
            return helper(node);
        }
    }

}

//tc: O(1)
//sc: O(1)


// Input: head = [1,2,2,1]
// Output: true
// Example 2:


// Input: head = [1,2]
// Output: false