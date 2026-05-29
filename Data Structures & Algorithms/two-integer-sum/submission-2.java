class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int reqv = target - nums[i];
            if(map.containsKey(reqv)){
                return new int[]{map.get(reqv), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{};

    }
}
