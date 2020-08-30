public class Leetcode50 {
    public double myPow(double x, int n) {
        // 分治： 终止条件 切分子问题 处理子问题合并子结果 处理状态
        if (x == 1) {
            return 1.0;
        }
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    public double fastPow(double x, long n) {
        // terminator
        if (n == 0) {
            return 1.0;
        }
        // 切分子问题
        double half = fastPow(x, n / 2);
        // 处理子问题 合并 子结果
        if (n % 2 == 1) {
            return half * half * x;
        } else {
            return half * half;
        }
    }
}