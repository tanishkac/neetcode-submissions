class Solution {
    public int maxArea(int[] heights) {

        int l = 0;
        int r = heights.length - 1;
        int max = 0;

        while(l < r) {
            while(l<r && heights[l] <= heights[r]) {
                max = Math.max((r-l) * heights[l], max);
                l++;
            }
            while(l<r && heights[l] > heights[r]) {
                max = Math.max((r-l) * heights[r], max);
                r--;
            }
        }

        return max;

    }
}
