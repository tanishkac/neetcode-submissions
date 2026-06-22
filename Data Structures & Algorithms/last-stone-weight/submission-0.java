class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones) {
            maxH.add(s);
        }

        while(maxH.size() > 1) {

            int x = maxH.remove();
            int y = maxH.remove();
            
            if(x == y) {
                continue;
            } 
            else if(x < y || x > y) {
                int z = Math.abs(x-y);
                maxH.add(z);
            }

        }

        return (maxH.size() != 0) ? maxH.peek() : 0;

    }
}
