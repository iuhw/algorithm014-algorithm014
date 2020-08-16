//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组 
// 👍 658 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] nums = new int[]{1, 2};
        System.out.println(Arrays.toString(nums));

        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            //1、先翻转数组 2、翻转前k个元素 3、翻转n-k个元素
            // 思考：[1,2,4,6]移动2步骤，相当于[(1,2),(4,6)] => [(4,6),(1,2)]，可否做切分数组再拼接，ArrayList
            // 如果数组长度为1或者k与数组长度相同，直接返回；
            if (nums == null || nums.length == 1) {
                return;
            }
            // 很精妙相当于
            // k=0时，无需移动
            // k < nums.length，移动k次
            // k = nums.length时，无需移动；
            // k > nums.length时只需移动 (k % nums.length)次，避免下标溢出问题
            k %= nums.length;
            //1、先翻转数组
            reverse(nums, 0, nums.length - 1);
            //2、翻转前k个元素
            reverse(nums, 0, k - 1);
            //3、翻转n-k个元素
            reverse(nums, k, nums.length - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            int temp;
            for (; start < end; start++, end--) {
                temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    // 暴力求解
    // 时间复杂度O(k*n) 空间复杂度O(1)
    class Solution1 {
        public void rotate(int[] nums, int k) {
            int tail, temp;
            for (int i = 0; i < k; i++) {
                tail = nums[nums.length - 1];
                for (int j = 0; j < nums.length; j++) {
                    temp = nums[j];
                    nums[j] = tail;
                    tail = temp;
                }
            }
        }
    }

    // 时间复杂度O(n) 空间复杂度O(n)
    class Solution2 {
        public void rotate(int[] nums, int k) {
            //开辟新空间，基本规律 i位置元素 移动到 (i+k)%nums.length
            int[] newArray = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                newArray[(i + k) % nums.length] = nums[i];
            }
            // 拷贝数组
            for (int i = 0; i < nums.length; i++) {
                nums[i] = newArray[i];
            }
        }
    }
}