class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, target, ans, new ArrayList<>());
        return ans;
    }

    public void backtrack(int ind, int[] nums, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(ind == nums.length) { 
            return;
        }
        
        if(nums[ind] <= target) {
            ds.add(nums[ind]);
            backtrack(ind, nums, target-nums[ind], ans, ds);
            ds.remove(ds.size() - 1);
        } 

        backtrack(ind+1, nums, target, ans, ds);

    }
}
