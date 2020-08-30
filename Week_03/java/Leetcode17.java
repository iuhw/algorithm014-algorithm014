import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Leetcode17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        search("", digits, 0, res, map);
        return res;
    }

    private void search(String s, String digits, int level, List<String> res, Map<String, String> map) {
        // terminator
        if (level == digits.length()) {
            res.add(s);
            return;
        }
        // process
        String letters = map.get(String.valueOf(digits.charAt(level)));
        // drill down
        for (int i = 0; i < letters.length(); i++) {
            search(s + letters.charAt(i), digits, level + 1, res, map);
        }
        // reverse
    }

    public static void main(String[] args) {
        Leetcode17 leetcode17 = new Leetcode17();
        System.out.println(leetcode17.letterCombinations("23"));
    }
}