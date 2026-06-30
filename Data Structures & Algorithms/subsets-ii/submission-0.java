class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsett(0, nums, ans, new ArrayList<>());
        return ans;
    }

    public void subsett(int ind, int[] nums, List<List<Integer>> ans, List<Integer> ds) {
        if(ind == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[ind]);
        subsett(ind+1, nums, ans, ds);
        ds.remove(ds.size() - 1);

        while((ind+1 < nums.length) && (nums[ind] == nums[ind+1])) {
            ind++;
        }
        subsett(ind+1, nums, ans, ds);
    }
}
