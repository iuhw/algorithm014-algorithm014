//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 318 👎 0


package leetcode.editor.cn;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        String s = "aba";
        System.out.println(solution.countSubstrings(s));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            // 可全量枚举后，比较字符串 O(n^3)
            // 升维 i,j=0  i j 相等  i-j < 2  或者   i+1 = j-1
            //状态：dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串。
            //状态转移方程：当 s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1]) 时，dp[i][j]=true，否则为false

            //作者：jawhiow
            //链接：https://leetcode-cn.com/problems/palindromic-substrings/solution/liang-dao-hui-wen-zi-chuan-de-jie-fa-xiang-jie-zho/
            boolean[][] b = new boolean[s.length()][s.length()];
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (i - j < 2 || b[j + 1][i - 1])) {
                        b[j][i] = true;
                        System.out.println(String.format("(%d,%d)",i,j));
                        count++;
                    }
                }
            }
            return count;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}