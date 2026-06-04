class Solution {
    public int trap(int[] height) {

        if(height.length < 3) {
            return 0;
        }

        int maxA = 0;

        for(int i=1; i<height.length-1; i++) {
            int area = 0;
            int l=i-1;
            int maxl = 0;
            int r=i+1;
            int maxr=0;

            while(l >= 0){
                maxl = Math.max(height[l], maxl);
                l--;
            }

            while(r <= height.length-1){
                maxr = Math.max(height[r], maxr);
                r++;
            }

            if(maxr > height[i] && maxl > height[i]) {
                area = Math.min(maxr, maxl) - height[i];
            }

            maxA = area + maxA;     
        }

        return maxA;

    }
}
