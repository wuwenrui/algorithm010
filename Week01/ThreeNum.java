/**
 * <p>
 *  给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 *
 * </p>
 *
 *
 * 思路： 1、三层嵌套循环 - 累加值，如果三数之和等于0，符合条件，但是需要借用拍重集合 Set
 *       2、枚举 + 夹逼法，枚举每一个没有被枚举过的数，双指针夹逼法，在枚举数后找符合条件的
 *
 *
 */
class ThreeNum{


    /**
     * 枚举 + 夹逼法
     *
     * 时间复杂度：O(n^2)
     *
     */
    private List<List<Integer>> threeNum(int[] nums){
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        // 正序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i + 1, r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[++l] );
                    while (l < r && nums[r] == nums[--r] );
                } else if (sum < 0) {
                    while (l < r && nums[l] == nums[++l]) ;
                } else {
                    while (l < r && nums[r] == nums[--r] );
                }
            }
        }
        return result;
    }



    private List<List<Integer>> method2(int[] nums) {
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        Set<LinkedList<Integer>> result = new LinkedHashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        LinkedList<Integer> tmp = new LinkedList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        result.add(tmp);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

}