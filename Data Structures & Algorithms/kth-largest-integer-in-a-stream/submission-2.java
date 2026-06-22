class KthLargest {

    PriorityQueue<Integer> pq;
    int m;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();

        for(int n : nums) {
            pq.add(n);
        }

        for(int i = 0; i< nums.length -k; i++) {
            pq.remove();
        }

        m = k;
    }
    
    public int add(int val) {

        if(pq.size() < m) {
            pq.add(val);
        }
        else if(pq.size() == m && pq.peek() < val) {
            pq.remove();
            pq.add(val);
        } 

        return pq.peek();
        
    }
}
