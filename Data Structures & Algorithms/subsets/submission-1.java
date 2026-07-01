class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    public void backtrack(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        if(ind == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[ind]);
        backtrack(ind+1, nums, ds, ans);
        ds.remove(ds.size() - 1);
        backtrack(ind+1, nums, ds, ans);
    }
}
