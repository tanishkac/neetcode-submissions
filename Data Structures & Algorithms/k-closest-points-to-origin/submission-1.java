class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1]));

        for(int[] p : points) {
            if(pq.size() < k) {
                pq.add(p);
            }
            else{
                int[] point = pq.peek();
                if((p[0]*p[0] + p[1]*p[1]) < (point[0]*point[0] + point[1]*point[1])) {
                    pq.remove();
                    pq.add(p);
                }
            }
        }

        int[][] result = new int[k][2];
        
        for(int i=0;i<k; i++) {
            result[i] = pq.remove();
        }

        return result;
    }
}
