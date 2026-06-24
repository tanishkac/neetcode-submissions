class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int weight : stones) {
            pq.add(weight);
        }

        while(pq.size() > 1) {

            int x = pq.remove();
            if(x == pq.peek()) {
                pq.remove();
            }
            else {
                int y = Math.abs(pq.remove() - x);
                pq.add(y);
            }
    
        } 

        return (!pq.isEmpty()) ? pq.peek() : 0;

    }
}
