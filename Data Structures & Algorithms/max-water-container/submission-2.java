class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length-1;
        int maxWater = r * Math.min(heights[l], heights[r]);
        int water;

        while(l < r){

            if(heights[l] < heights[r]){
                l++;
                water = (r-l) * Math.min(heights[l], heights[r]);
                maxWater = Math.max(water, maxWater);
            } else { 
                r--;
                water = (r-l) * Math.min(heights[l], heights[r]);
                maxWater = Math.max(water, maxWater);
            }

        }

        return maxWater;
    }
}
