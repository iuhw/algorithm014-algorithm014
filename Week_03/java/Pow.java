class Pow {
    public double myPow(double x, int n) {
        // 暴力法 O(n) 注意n正负值
        // 分治法 O(logn) x^n => x^(n/2) * x^(n/2)  注意奇偶数
        // 处理n为负数的情况
        int N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        // 分治
        return helper(x, N);
    }

    double helper(double x, int n) {
        // terminator
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        // process 
        double half = helper(x, n / 2);
        // drill down
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
        // reverse states
    }

    public static void main(String[] args) {
        Pow p = new Pow();
        System.out.println(p.myPow(2.00000, -2147483648));
    }
}