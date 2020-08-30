import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/generate-parentheses/
// 使用递归方式解决
public class Leetcode22 {
    public List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        recursionGenerate(0, 0, n, "");
        return list;
    }

    private void recursionGenerate(int left, int right, int n, String s) {
        // terminator
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        // process
        // drill down
        if (left < n) {
            recursionGenerate(left + 1, right, n, s + "(");
        }
        if (left > right)
            recursionGenerate(left, right + 1, n, s + ")");
        // reverse states
    }

    public static void main(String[] args) {
        Leetcode22 solution = new Leetcode22();
        solution.generateParenthesis(3);
        System.out.println(solution.list);
    }
}