//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针 
// 👍 590 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = new int[]{4, 7, 9, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 3};
        int m = 3;
        int n = 3;

        solution.merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {

            // nums1 从尾部开始
            int p1 = m - 1;
            // nums2 从尾部开始
            int p2 = n - 1;
            // nums1 从尾部开始
            int p = m + n - 1;

            while (p1 >= 0 && p2 >= 0) {
                nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
            }
            //nums2还有剩余元素
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    // 时间复杂 O(m+n)log(m+n)  空间复杂度O(1)
    class Solution1 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 先拷贝
            System.arraycopy(nums2, 0, nums1, m, n);
            // 再排序
            Arrays.sort(nums1);
        }
    }

    // 时间复杂度O(m+n) 空间复杂度O(n)
    class Solution2 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 开辟新数组
            int[] nums1_copy = new int[m];
            System.arraycopy(nums1, 0, nums1_copy, 0, m);

            // nums1_copy 从头开始
            int p1 = 0;
            // nums2 从头开始
            int p2 = 0;
            // nums1 从头开始
            int p = 0;

            while (p1 < m && p2 < n) {
                nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
            }
            //如果nums1_copy还有剩余元素
            if (p1 < m) {
                System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
            }
            //如果nums2还有剩余元素
            if (p2 < n) {
                System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
            }
        }
    }
}