//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1214 👎 0


package leetcode.editor.cn;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode l1 = new MergeTwoSortedLists().new ListNode(4);
        l1 = new MergeTwoSortedLists().new ListNode(2, l1);
        l1 = new MergeTwoSortedLists().new ListNode(1, l1);

        ListNode l2 = new MergeTwoSortedLists().new ListNode(4);
        l2 = new MergeTwoSortedLists().new ListNode(3, l2);
        l2 = new MergeTwoSortedLists().new ListNode(1, l2);

        ListNode l = solution.mergeTwoLists(l1, l2);
        while (l != null) {
            System.out.print(" " + l.val);

            l = l.next;
        }
        System.out.println();
    }

    class ListNode {
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
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */


    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            } else if (l1.val <= l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    // 迭代比较方法 时间复杂度O(n) 空间复杂度 O(1)
    class Solution1 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode prehead = new ListNode(-1);
            ListNode prev = prehead;
            // 迭代比较
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }
            // 将链表末尾指向未合并完的链表即可
            prev.next = l1 == null ? l2 : l1;

            return prehead.next;
        }
    }

}