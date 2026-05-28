class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int sum;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        List<Integer> a = Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[k]
                        );
                        Collections.sort(a);
                        if(result.contains(a) == false){
                            result.add(a);
                        }
                    }
                }
            }
        }
        return result;
    }
}
