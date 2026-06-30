class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combination(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    public void combination(int ind, int[] candidates, int target, List<Integer> ds, List<List<Integer>> ans) {

        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        } 

        if(ind == candidates.length) { 
            return;
        }

        if(candidates[ind] <= target) {
            ds.add(candidates[ind]);
            combination(ind + 1, candidates, target - candidates[ind], ds, ans);
            ds.remove(ds.size() - 1);
        }

        while(ind+1 < candidates.length && candidates[ind] == candidates[ind + 1]) {
            ind++;
        }
        combination(ind + 1, candidates, target, ds, ans);
    }

}
