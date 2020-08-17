//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2474 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{0, 0, 0, 0, 0, 0};

        List<List<Integer>> list = solution.threeSum(nums);

        System.out.printf(list.toString());

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();

            // 枚举a
            for (int first = 0; first < n; first++) {
                int tartget = -nums[first];
                int third = n - 1;
                // 相邻元素不要重复，第一次不校验
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                // 第二重循环从 first+1 开始
                for (int second = first + 1; second < n; second++) {

                    // 第二重循环有需要与第2个元素不重复
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    // 保证second 在 third 左边
                    while (second < third && nums[second] + nums[third] > tartget) {
                        --third;
                    }

                    if (second == third) {
                        break;
                    }

                    if (nums[second] + nums[third] == tartget) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ans.add(list);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}