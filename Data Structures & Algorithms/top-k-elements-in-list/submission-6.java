class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int[] list = new int[k];
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int i=0; i<k; i++) {
            int maxF = 0;
            int kee = 0;

            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() >= maxF) {
                    kee = entry.getKey();
                    maxF = entry.getValue();
                } 
            }
            list[i] = kee;
            map.remove(kee);
            maxF = 0;

        }

        return list;
    }
}
