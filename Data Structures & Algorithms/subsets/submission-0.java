class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsetss(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void subsetss(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ans) {

        if(ind == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[ind]);
        subsetss(ind+1, nums, ds, ans);

        ds.remove(ds.size() - 1);
        subsetss(ind+1, nums, ds, ans);
        
    }

}
