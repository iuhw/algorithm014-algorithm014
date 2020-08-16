//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 698 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] nums = new int[]{0, 0, 1, 3, 4};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            // 双指针，p从头开始,q=0为标记位，如果p不为零
            if (nums == null || nums.length == 1) {
                return;
            }
            int q = 0;
            for (int p = 0; p < nums.length; p++) {
                if (nums[p] != 0) {
                    int temp = nums[p];
                    nums[p] = nums[q];
                    nums[q++] = temp;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    // 执行失败，未考虑顺序问题
    class Solution1 {
        public void moveZeroes(int[] nums) {
            // 双指针，p为头，q为尾部，p++如果p位为零q位不为零互换，q位为零或q位发生互换q--
            for (int p = 0, q = nums.length - 1; p < q; p++) {
                if (nums[q] == 0) {
                    q--;
                }
                if (nums[p] == 0 && nums[q] != 0) {
                    nums[p] = nums[q];
                    nums[q] = 0;
                    q--;
                }
            }
        }
    }
}