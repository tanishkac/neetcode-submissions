class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] t = new boolean[nums.length];
        permutee(t, nums, new ArrayList<>(), ans);
        return ans;
    }
    public void permutee(boolean[] t, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        int n = nums.length;
        if(ds.size() == n) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0; i<n; i++) {
            if(t[i] == true) {
                continue;
            }

            ds.add(nums[i]);
            t[i] = true;
            permutee(t, nums, ds, ans);
            ds.remove(ds.size() - 1);
            t[i] = false;
        }
        
    }
}
