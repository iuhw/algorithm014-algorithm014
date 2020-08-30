public class Leetcode70 {
    public int climbStairs(int n) {
        // 尾递归方式
        return recursion(n, 1, 1);
    }

    public int recursion(int n, int a, int b) {
        // terminator
        if (n == 1) {
            return b;
        }
        // process current logic
        // drill down
        return recursion(n - 1, b, a + b);
        // reverse current status

    }
}