//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 442 👎 0


package leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) {
                return new ArrayList<>();
            }
            // 使用map
            Map<String, List<String>> map = new HashMap<>(strs.length);
            for (String s : strs) {
                char[] ca = s.toCharArray();
                Arrays.sort(ca);
                // 关键点在于此
                String key = String.valueOf(ca);
                // 如果没有包含则是初始化
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                // 并加入集合
                map.get(key).add(s);
            }
            return new ArrayList<>(map.values());
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}