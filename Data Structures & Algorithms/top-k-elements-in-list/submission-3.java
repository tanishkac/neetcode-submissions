class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }


        int[] arr = new int[k];
        for(int i=0; i<k; i++) {
            int maxV = 0;
            int maxK = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(maxV < entry.getValue()) {
                    maxV = entry.getValue();
                    maxK = entry.getKey();
                }
            }
            arr[i] = maxK;
            map.remove(maxK);
        }
        
        return arr;

    }
}
