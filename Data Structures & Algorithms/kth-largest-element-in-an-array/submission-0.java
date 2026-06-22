class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
        int kle = nums[0];
        for(int num : nums) {
            maxH.add(num);
        }

        for(int i = 0; i<k; i++) {
            kle = maxH.poll();
        }

        return kle;
    }
}
