学习笔记
# 递归
* 通过函数体来进行的循环。
* 向下进入到不同的层、向上返回到原来的层
* 对称性：他不能跳跃、只能层层下去再层层返回原来的层
* 递归代码模板：
```
public void recur(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
    // process result
    return;
    }
    // process current logic
    process(level, param);
    // drill down
    recur( level: level + 1, newParam);
    // restore current status
}
```
* 递归思维要点
    1. 不要人肉进行递归（最大误区）
    2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
    3. 数学归纳法思维
* 习题，leetcode[70爬楼梯]、[22括号生成]
# 尾递归
* 当递归调用的是整个函数体中最后执行的语句 && 它的返回值不属于表达式的一部分
* 原理：通过覆盖当前的栈帧而不是在其之上重新添加一个，这样所使用的栈空间就大大缩减了，这使得实际的运行效率会变得更高。
* 代码示例：
```java
class Leetcode70 {
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
```
# 分治 Divide & Conquer
* 本质上就是一种特殊的递归，本质上就是找重复性
* 学习目标：碰到一个问题就是找到它的重复性，最近重复性或者最优重复性
* 分治代码模板
```java
private static int divide_conquer(Problem problem){
    // recursion terminator
    if (problem == null){
        int res = process_last_result();
        return res;
    }
    // prepare data
    subproblem = split_problem(problem);
    // conquer subproblems
    res0 = divide_conquer(subproblem[0]);
    res1 = divide_conquer(subproblem[1]);
    // process and generate the final result
    result = process_result(res0,res1);
    // revert the current level states if neeeded
    return result;
}
```
* 递归代码模板
```python
def recursion(level,param1,param2,...):
    # recursion terminator
    if level > MAX_LEVEL:
        process_result;
        return ;
    # process logic in current level
    process(level,data...)
    # drill down
    recursion(level+1,p1,...)
    # reverse the current level status if needed
```
# 回溯 Backtracking
* 概念
> 回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程
  中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将
  取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问
  题的答案。
* 回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种
  情况：
  1. 找到一个可能存在的正确的答案；
  2. 在尝试了所有可能的分步方法后宣告该问题没有答案。
* 在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

# 练习题
> 分治: terminator -> process(split problem)  -> drill down(subproblemes) && merge(result) -> reverse states
* [Leetcode[50]](https://leetcode-cn.com/problems/powx-n/) ***高频***

# 晕菜，回头复习下递归的执行流程
