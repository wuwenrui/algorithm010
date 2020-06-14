/**
 *
 * <p>
 *  给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)
 *  。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * </p>
 *
 *
 *
 *
 *
 *
 */

class MoreWater{

    /**
     * 两次遍历，穷举所有可能，找出面积最大的
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     */
    private int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }


    /**
     * 双指针法，数组两边，代替容器边界，移动较小值，较小值决定容器容量
     * 为什么移动较小值，
     * 因为，如果移动较大值的话，长度缩短，并且新柱子的高度可能比短柱子矮。
     * 移动短柱子的话，新柱子可能比短柱子高
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private int method2(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;
        for (int i = 0; i < height.length; i++) {
            int left = height[l], right = height[r];
            int area = (r - l) * Math.min(left, right);
            max = Math.max(area, max);
            // 移动指针，较小的移动
            if (left <= right) {
                ++l;
            } else {
                --r;
            }
        }
        return max;
    }

    /**
     * 双指针，不同写法，速度 更快
     */
    private int method3(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l != r) {
            if (height[l] <= height[r]) {
                int area = (r - l) * Math.min(height[l], height[r]);
                max = Math.max(max, area);
                ++l;
            } else {
                int area = (r - l) * Math.min(height[l], height[r]);
                max = Math.max(max, area);
                --r;
            }
        }
        return max;
    }

}