//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 526 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        int[] digits = new int[]{9,9,9};
        int[] res = solution.plusOne(digits);
        System.out.println(Arrays.toString(res));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 时间复杂度 O(n),空间复杂度O(n)
        public int[] plusOne(int[] digits) {
            for (int j = digits.length - 1; j >= 0; j--) {
                if (digits[j] == 9) {
                    digits[j] = 0;
                } else {
                    digits[j]++;
                    return digits;
                }
            }
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            return newArray;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}