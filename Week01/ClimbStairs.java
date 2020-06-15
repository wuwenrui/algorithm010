/**
 * <p>
 *     假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 *      每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *      注意：给定 n 是一个正整数。
 *
 *  示例1：
 *      输入： 2
 *      输出： 2
 *      解释： 有两种方法可以爬到楼顶。
 *      1.  1 阶 + 1 阶
 *      2.  2 阶
 *
 *  示例2：
 *      输入： 3
 *      输出： 3
 *      解释： 有三种方法可以爬到楼顶。
 *      1.  1 阶 + 1 阶 + 1 阶
 *      2.  1 阶 + 2 阶
 *      3.  2 阶 + 1 阶
 *
 * </p>
 */

class ClimbStairs {

    /**
     * f(n) = f(n-1) + f(n-2)
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private int method1(int n) {
        if(i <= 2){
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i < n + 1; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }


    /**
     * 数组填充方法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1) -- 开辟一个数组算是 O(1) 吗？空间复杂度的标准是按照元素个数来算，还是按照实例个数来算呢？过后确认回来更改
     */
    private int method2(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }



}