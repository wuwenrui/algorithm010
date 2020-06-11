/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 一般数组难题多想想快慢双指针法和两边夹逼法（重点）
 *
 * 思路：
 * 1、利用指针：当前指针位置不为0，将 j 指针位置赋值为 当前指针位置数据，并且如果 j 和当前指针索引不一致，赋值当前指针位置为 0，j++
 * 2、统计0出现的次数，开辟新数组，非0元素放在新数组开始位置，然后再开一个循环用来补0
 *
 *
 */

class MoveZero {

    /**
     * 利用指针方法实现移动 0
     * 定义一个指针，遍历，如果不为0，将 j 指针处数赋值为 nums[i] , and 如果 i != j，nums[i] = 0, j 自增
     * 为什么要判断 i != j , 因为如果数组只有一位的时候且不为0，结果输出为0，不符合预期
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     */
    public void method1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[j] = nums[i];
                if(i != j){
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    /**
     * 覆盖法
     * 慢指针处赋值为非0元素，另开循环，从慢指针的下一个位置开始赋值0
     * 定义指针，双循环， 先记录非 0 元素，然后从最后一个非 0 元素位置的下一个开始补 0
     *
     * 时间复杂度：O(2n) 循环两次
     * 空间复杂度：O(1) 开辟常数级变量
     */
    private static void method2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        // 1，12，50，100，0，50，100
        System.out.println("第一次循环结束后： ");
        for (int num : nums) {
            System.out.print(num + " , ");
        }
        // j = 5
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    /**
     * 开辟新数组 -
     * 新数组长度为题目给出的数组长度
     * 统计 0 出现的个数，将非 0 元素放在新数组前面，然后将 0 的元素放在数组后面
     *
     * 时间复杂度：循环两次，所以是 O(n) 的
     * 空间复杂度：开辟了新数组 O(1)
     *
     */
    private static void method3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] newNums = new int[nums.length];
        int zeroCount = 0;
        int newNumsIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                newNums[newNumsIndex++] = nums[i];
            } else {
                zeroCount++;
            }
        }
        for (int i = newNumsIndex + 1; i < zeroCount; i++) {
            newNums[i] = 0;
        }
        for (int newNum : newNums) {
            System.out.print(newNum + ",");
        }
    }


    /**
     * 双指针 + 交换
     * 将非0元素和前面的元素交换位置
     *
     * 时间复杂度：O(n) -- 循环一次
     * 空间复杂度：O(1) -- 开两个变量，但是常数级，不随 n 变化
     */
    private static void method4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0, j = 0;
        for (; i < nums.length; i++) {
            if(nums[i] != 0){
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j++;
            }
        }
    }

    /**
     * 覆盖法
     * 慢指针被非0元素覆盖，慢指针的结束位置开始赋值为0
     *
     * 时间复杂度：循环两次- O(2n)
     * 空间复杂度：开常数级变量 - O(1)
     */
    private static void method5(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int j = 0;
        for (int num : nums) {
            if(num != 0){
                nums[j++] = num;
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }

    /**
     * 双指针，也是交换位置的思想， j 索引永远比 i 节点要小
     *
     * 时间复杂度：O(n) -- 循环一次
     * 空间复杂度：O(1) -- 开辟一个变量内存，因为这个变量
     *
     */
    private static void method6(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                int tmp = nums[j];
                nums[j++] = nums[i];
                nums[i] = tmp;
            }
        }
    }


    /**
     * 滚雪球做法：雪球作为0元素的统计，如果雪球大于0，则需要交换位置，拿当前节点和雪球起始位置交换
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static void snowBall(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int snowBall = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowBall++;
            } else if (snowBall > 0) {
                int t = nums[i];
                nums[i] = 0;
                nums[i - snowBall] = t;
            }
        }
    }

}