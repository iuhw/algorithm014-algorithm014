//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针 
// 👍 1578 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
//        int[] nums = new int[]{1, 1, 2, 3, 4, 4, 5};
        int[] nums = new int[]{1, 2};

        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 双指针方法
     * 解题思路：
     * 首先注意数组是有序的，那么重复的元素一定会相邻。
     *
     * 要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。
     *
     * 考虑用 2 个指针，一个在前记作 p，一个在后记作 q，算法流程如下：
     *
     * 1.比较 p 和 q 位置的元素是否相等。
     *
     * 如果相等，q 后移 1 位
     * 如果不相等，将 q 位置的元素复制到 p+1 位置上，p 后移一位，q 后移 1 位
     * 重复上述过程，直到 q 等于数组长度。
     *
     * 返回 p + 1，即为新数组长度
     *
     * 作者：max-LFszNScOfE
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            // 考虑数组长度为0的情况
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // 慢指针 i
            int i = 0;
            // 快指针 j
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    if (j - i > 1) {
                        nums[i + 1] = nums[j];
                    }
                    i++;
                }
            }
            return i + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}