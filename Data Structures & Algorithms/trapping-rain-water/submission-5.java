class Solution {
    public int trap(int[] height) {
        if(height.length < 3) {
            return 0;
        }

        int water = 0;
        int maxl = height[0];

        int[] maxr = new int[height.length];
        maxr[maxr.length-1] = height[height.length - 1];

        for(int i = height.length - 2; i>=0; i--) {
            maxr[i] = Math.max(maxr[i+1], height[i+1]);
        }

        for(int i=1; i<height.length-1; i++) {
            
            maxl = Math.max(maxl, height[i-1]);

            if(maxl >= height[i] && maxr[i] >= height[i]) {
                water = water + Math.min(maxl, maxr[i]) - height[i];
            } 
        }

        return water;
    }
}
