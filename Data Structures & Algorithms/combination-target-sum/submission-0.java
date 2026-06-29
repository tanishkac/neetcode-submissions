class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        combination(0, target, nums, ans, new ArrayList<>());
        return ans;

    }

    public void combination(int ind, int target, int[] nums, List<List<Integer>> ans,List<Integer> ds) {

        if(ind == nums.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(nums[ind] <= target) {
            ds.add(nums[ind]);
            combination(ind, target - nums[ind], nums, ans, ds);
            ds.remove(ds.size() - 1);
        }

        combination(ind+1, target, nums, ans, ds);

    }

}
