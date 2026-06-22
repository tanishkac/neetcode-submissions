class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minH = new PriorityQueue<>(
            (a,b) -> Integer.compare((a[0]*a[0] + a[1]*a[1]), (b[0]*b[0] + b[1]*b[1]))
            );
        int[][] ans = new int[k][2];

        for(int[] p : points) {
            minH.add(p);
        }

        for(int i=0; i<k; i++) {
            ans[i] = minH.poll();
        }

        return ans;

    }
}
