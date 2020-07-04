public class TwoSum{

    /**
     * 使用一遍 hash 法
     *
     *
     */
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (!map.containsKey(tmp)) {
                map.put(nums[i], i);
            }else {
                return new int[]{map.get(tmp), i};
            }
        }
        return null;
    }

}