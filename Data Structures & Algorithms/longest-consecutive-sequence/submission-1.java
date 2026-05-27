class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
        
        int current = nums[0];
        int longest = 1;
        int length;

        for(int num : set){
            if(!set.contains(num-1)){
                current = num;
                length = 1;

                while(set.contains(current+1)){
                    current++;
                    length++; 
                }
                longest = Math.max(longest, length);
            }
            
        }

        return longest;
        

    }
}
